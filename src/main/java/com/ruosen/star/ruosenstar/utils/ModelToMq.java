package com.ruosen.star.ruosenstar.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruosen.star.ruosenstar.annotation.PushMqJsonElement;
import com.ruosen.star.ruosenstar.annotation.PushMqJsonSerializable;
import com.ruosen.star.ruosenstar.exception.CustomException;
import com.ruosen.star.ruosenstar.module.Enums.ResultInfoEnum;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  实体到mq字段的映射
 *  * @projectName ruosen-star
 *  * @title     ModelToMq   
 *  * @package    com.ruosen.star.ruosenstar.module.base  
 *  * @author Administrator     
 *  * @date   2019/10/3 0003 星期四
 *  * @version V1.0.0
 *  
 */
@Slf4j
public class ModelToMq {

    /**
     * 检查对象是否使用PushMq注解
     */
    private void checkifAddAnnotation(Object object) {
        if (Objects.isNull(object)) {
            throw new CustomException(ResultInfoEnum.USER_IS_NOT_EXIST);
        }
        Class<?> clz = object.getClass();
        if (!clz.isAnnotationPresent(PushMqJsonSerializable.class)) {
            throw new CustomException(clz.getSimpleName() + "没有添加pushMq注解");
        }
    }

    /**
     * 获取字段名
     *
     * @param field
     * @return
     */
    private String getKey(Field field) {
        String value = field.getAnnotation(PushMqJsonElement.class).value();
        return value.isEmpty() ? field.getName() : value;
    }

    /**
     * 日期格式化
     *
     * @param pattern
     * @param date
     * @return
     */
    private String dateFormat(String pattern, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String format = dateFormat.format(date);
        return format;
    }

    /**
     * 获取字段值
     *
     * @param field
     * @param object
     * @param mapList
     * @return
     */
    private Object getValue(Field field, Object object, List<Map<String, Object>> mapList) throws Exception {
        if (List.class.isAssignableFrom(field.getType())) {
            List list = (List) field.get(object);

            if (mapList == null) {
                mapList = new ArrayList<>();
            }
            if (null != list) {
                for (Object o : list) {
                    Map<String, Object> maps = getFields(o, mapList, null);
                    mapList.add(maps);
                }
            }
            return mapList;
        }

        String pattern = field.getAnnotation(PushMqJsonElement.class).dateFormat();

        if (Date.class.isAssignableFrom(field.getType())) {
            Date date = (Date) field.get(object);
            if (null != date) {
                return dateFormat(pattern, date);
            }
        }
        return field.get(object);
    }

    /**
     * 获取字段名与值
     *
     * @param obj
     * @param mapList
     * @param exclusionOtherFiled
     * @return
     */
    private Map<String, Object> getFields(Object obj, List<Map<String, Object>> mapList, String exclusionOtherFiled) throws Exception {
        Class<?> clazz = obj.getClass();

        PushMqJsonSerializable pushMqJsonSerializable = clazz.getAnnotation(PushMqJsonSerializable.class);
        String[] exclusions = pushMqJsonSerializable.exclusions();

        List<Field> fieldList = new ArrayList<>();

        while (null != clazz) {
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        Map<String, Object> jsonElements = new LinkedHashMap<>();

        kkk:
        for (Field field : fieldList) {
            String fieldName = field.getName();
            if (exclusions.length > 0) {
                for (String exclusion : exclusions) {
                    if (exclusion.equals(fieldName)) {
                        break kkk;
                    }
                }
            } else if (null != exclusionOtherFiled) {
                String exclusion = "";
                if ("save".equals(exclusionOtherFiled)) {
                    exclusion = "updateBy";
                } else if ("update".equals(exclusionOtherFiled)) {
                    exclusion = "createBy";
                }
                if (exclusion.equals(fieldName)) {
                    continue;
                }
            }
            field.setAccessible(true);
            if (field.isAnnotationPresent(PushMqJsonElement.class)) {
                jsonElements.put(getKey(field), getValue(field, obj, mapList));
            }
        }
        return jsonElements;
    }

    /**
     * json->String
     *
     * @param object
     * @param operate
     * @return
     */
    public String getJsonToString(Object object, String operate) throws Exception {
        checkifAddAnnotation(object);
        Map<String, Object> fields = getFields(object, null, operate);

        if (object != null) {
            fields.put("operate", operate);
        }
        return new ObjectMapper().writeValueAsString(fields);
    }

}

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('1000001', '首页', '/home', '1', null, null, 'home', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, 'Y');

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('2000001', '商品', '/products', '1', null, null, 'appstore', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('20000010001', '品类管理', '/category', '1', '2000001', '1', 'bars', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('20000010002', '商品管理', '/product', '1', '2000001', '2', 'tool', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);


INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('3000001', '用户管理', '/user', '1', null, null, 'user', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('4000001', '角色管理', '/role', '1', null, null, 'safety', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('5000001', '图形图表', '/charts', '1', null, null, 'area-chart', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('50000010001', '柱形图', '/charts/bar', '1', '5000001', '1', 'bar-chart', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('50000010002', '折线图', '/charts/line', '1', '5000001', '2', 'line-chart', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('50000010003', '饼图', '/charts/pie', '1', '5000001', '3', 'pie-chart', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);

INSERT INTO `ruosen-star`.`sys_menu` (`menu_code`, `menu_name`, `url`, `levels`, `parent_code`, `sort_num`, `icon`,
                                      `remark1`, `remark2`, `remark3`, `remark4`, `remark5`, `create_date`, `create_by`,
                                      `update_date`, `update_by`, `is_delete`, `enable`, `is_public`)
VALUES ('6000001', '订单管理', '/order', '1', null, null, 'windows', null, null, null, null, null, NOW(), 'ruosen', null,
        null, DEFAULT, DEFAULT, DEFAULT);
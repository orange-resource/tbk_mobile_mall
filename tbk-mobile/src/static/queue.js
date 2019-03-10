/**
 * localStorage封装
 * @author Orange软件
 * @date 2019.3.10
 */
function local() {}
local.setJson = function(key,value) {

    let jsonString = JSON.stringify(value);
    localStorage.setItem(key,jsonString);
};
local.getJson = function (key) {

    let jsonString = localStorage.getItem(key);
    return JSON.parse(jsonString);
};
local.clear = function () {

    localStorage.clear();
};
local.removeItem = function (key) {

    localStorage.removeItem(key);
};

/**
 * 队列封装
 * @author Orange软件
 * @date 2019.3.10
 */
function queue() {}
queue.get = function (key) { //获取队列里面全部的数据

    let data = local.getJson(key);
    if (data instanceof Array) {
        return data;
    }
    return [];
};
queue.insert = function (param) { //队列插入数据

    param.capacityNum = param.capacityNum || 100; //队列容量 默认队列中超过100条数据，自动删除尾部

    let data = local.getJson(param.key);
    if (data instanceof Array) {
        if (data.length > param.capacityNum) {
            let total = data.length - param.capacityNum;
            for (let i = 0;i < total;i++) {
                data.pop();
            }
        }
        data.unshift(param.value);
    } else {
        data = [];
        data.push(param.value);
    }
    local.setJson(param.key,data);
};
queue.clear = function () { //清空所有队列

    localStorage.clear();
};
queue.removeItem = function (key,itemIds) { //提供itemIds数组 批量删除队列中的某项数据

    let data = local.getJson(key);
    if (data instanceof Array) {
        for (let i = 0;i < itemIds.length;i++) {
            for (let p = 0;p < data.length;p++) {
                if (itemIds[i] == data[p].itemId) {
                    data.splice(p, 1);
                    break;
                }
            }
        }
        local.setJson(key,data);
    }
};
queue.isExist = function (key,itemId) { //检测某条数据在队列中是否存在

    let data = local.getJson(key);
    if (data instanceof Array) {
        for (let p = 0;p < data.length;p++) {
            if (itemId == data[p].itemId) {
                return true;
            }
        }
    }
    return false;
};
queue.remove = function (key) { //删除某条队列

    localStorage.removeItem(key);
};
queue.getCount = function (key) { //获取队列中全部数据数量

    let data = local.getJson(key);
    if (data instanceof Array) {
        return data.length;
    }
    return 0;
};

export {
    local,queue
}

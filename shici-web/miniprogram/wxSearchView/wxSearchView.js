/***
 * // 定义数据格式
 * "wxSearchData":{
 *  configconfig:{
 *    style: "wxSearchNormal"
 *  },
 *  view:{
 *    hidden: true,
 *    searchbarHeght: 20
 *  }
 *  hotKeys:[],//自定义热门搜索
 *  his:[]//历史搜索关键字
 *  value
 * }
 */

// 提示集合
let __tipKeys = [];
// 搜索回调函数
let __searchFunction = null;
// 返回函数
let __goBackFunction = null;
// 应用变量
let __that = null;

// 初始化函数
function init(that, hotKeys, tipKeys, searchFunction, goBackFunction) {
    __that = that;
    __tipKeys = tipKeys;
    __searchFunction = searchFunction;
    __goBackFunction = goBackFunction;

    let temData = {};
    let barHeight = 43;
    let view = {
        barHeight: barHeight
    };
    temData.hotKeys = hotKeys;

    wx.getSystemInfo({
        success: function (res) {
            let wHeight = res.windowHeight;
            view.seachHeight = wHeight - barHeight;
            temData.view = view;
            __that.setData({
                wxSearchData: temData
            });
        }
    });

    getHisKeys(__that);
}

// 搜索框输入时候操作
function wxSearchInput(e) {
    let inputValue = e.detail.value;
    // 页面数据
    let temData = __that.data.wxSearchData;
    // 寻找提示值
    let tipKeys = [];
    if (inputValue && inputValue.length > 0) {
        for (let i = 0; i < __tipKeys.length; i++) {
            let mindKey = __tipKeys[i];
            // 包含字符串
            if (mindKey.indexOf(inputValue) !== -1) {
                tipKeys.push(mindKey);
            }
        }
    }
    // 更新数据
    temData.value = inputValue;
    temData.tipKeys = tipKeys;
    // 更新视图
    __that.setData({
        wxSearchData: temData
    });
}

// 清空输入
function wxSearchClear() {
    // 页面数据
    let temData = __that.data.wxSearchData;
    // 更新数据
    temData.value = "";
    temData.tipKeys = [];
    // 更新视图
    __that.setData({
        wxSearchData: temData,
        poems: [],
        poets: [],
        sentences: [],
        tags: []
    });
}

// 点击提示或者关键字、历史记录时的操作
function wxSearchKeyTap(e) {
    search(e.target.dataset.key);
}

// 确任或者回车
function wxSearchConfirm(e) {
    let key = e.target.dataset.key;
    if (key === "back") {
        __goBackFunction();
    } else {
        search(__that.data.wxSearchData.value);
    }
}

function search(inputValue) {
    if (inputValue && inputValue.length > 0) {
        let pattern = new RegExp(/^[\u4E00-\u9FA5]{1,8}$/);
        if (pattern.test(inputValue)) {
            // 添加历史记录
            wxSearchAddHisKey(inputValue);
        }
        // 更新
        let temData = __that.data.wxSearchData;
        temData.value = inputValue;
        __that.setData({
            wxSearchData: temData
        });
        // 回调搜索
        __searchFunction(inputValue);
    }
}

// 读取缓存
function getHisKeys() {
    let value = [];
    try {
        value = wx.getStorageSync("wxSearchHisKeys");
        if (value) {
            // Do something with return value
            let temData = __that.data.wxSearchData;
            temData.his = value;
            __that.setData({
                wxSearchData: temData
            });
        }
    } catch (e) {
        // Do something when catch error
    }
}

// 添加缓存
function wxSearchAddHisKey(inputValue) {
    if (!inputValue || inputValue.length === 0) {
        return;
    }
    let value = wx.getStorageSync("wxSearchHisKeys");
    if (value) {
        if (value.indexOf(inputValue) < 0) {
            value.unshift(inputValue);
        }
        wx.setStorage({
            key: "wxSearchHisKeys",
            data: value,
            success: function () {
                getHisKeys(__that);
            }
        });
    } else {
        value = [];
        value.push(inputValue);
        wx.setStorage({
            key: "wxSearchHisKeys",
            data: value,
            success: function () {
                getHisKeys(__that);
            }
        });
    }
}

// 删除缓存
function wxSearchDeleteAll() {
    wx.removeStorage({
        key: "wxSearchHisKeys",
        success: function (res) {
            let value = [];
            let temData = __that.data.wxSearchData;
            temData.his = value;
            __that.setData({
                wxSearchData: temData
            });
        }
    });
}

// 导出接口
module.exports = {
    init: init, //初始化函数
    wxSearchInput: wxSearchInput, // 输入变化时的操作
    wxSearchKeyTap: wxSearchKeyTap, // 点击提示或者关键字、历史记录时的操作
    wxSearchDeleteAll: wxSearchDeleteAll, // 删除所有的历史记录
    wxSearchConfirm: wxSearchConfirm, // 搜索函数
    wxSearchClear: wxSearchClear // 清空函数
};

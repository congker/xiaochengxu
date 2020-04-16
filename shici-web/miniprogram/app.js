// const cloud = require('wx-server-sdk');
wx.cloud.init();
App({
    onLaunch: function () {
        wx.cloud.callFunction({
            // 云函数名称
            name: 'login',
            // 传给云函数的参数
            data: {
                a: 1,
                b: 2,
            },
            success: function (res) {
                console.log(res.result.sum) // 3
            },
            fail: console.error
        });
        if (!wx.cloud) {
            console.error('请使用 2.2.3 或以上的基础库以使用云能力')
        } else {
            wx.cloud.init({
                // env 参数说明：
                //   env 参数决定接下来小程序发起的云开发调用（wx.cloud.xxx）会默认请求到哪个云环境的资源
                //   此处请填入环境 ID, 环境 ID 可打开云控制台查看
                //   如不填则使用默认环境（第一个创建的环境）
                env: wx.cloud.DYNAMIC_CURRENT_ENV,
                traceUser: true,
            })
        }

        this.globalData = {}
    }
});

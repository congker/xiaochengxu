// pages/userConsole/userConsole.js
Page({

  data: {
    openid: ''
  },

    /**
    * 加载
    * */
  onLoad: function (options) {
    this.setData({
      openid: getApp().globalData.openid
    })
  }
})
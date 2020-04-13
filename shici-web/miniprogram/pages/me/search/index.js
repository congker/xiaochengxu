// pages/me/search/index.js
const app = getApp();
import {
	GET_SEARCH_LIST,
	LOADFAIL,
	UPDATE_SEARCH_STATE
} from "../../../apis/request";
let current_page = 1;
let last_page = 1;
Page({
	/**
	 * 页面的初始数据
	 */
	data: {
		user_id: 0,
		lists: [],
		a_total: 0
	},
	// 获取用户id
	getUserId: function() {
		let user = wx.getStorageSync("user");
		let user_id = user ? user.user_id : 0;
		this.setData({
			user_id: user_id
		});
	},
	// 更新状态
	update: function(event) {
		let that = this;
        let id = event.currentTarget.dataset.id;
        const data = {
            id,

        }
		wx.showModal({
			title: "提示",
			content: "确定删除吗？",
			success: function(res) {
				if (res.confirm) {
					UPDATE_SEARCH_STATE('GET',data)
						.then(res => {
							if (res.data && res.data.status == 200) {
								that.data.lists.map(function(item, index) {
									if (item.id == id) {
										that.data.lists.splice(index, 1);
									}
								});
								that.setData({
									lists: that.data.lists
								});
								wx.showToast({
									title: "删除成功",
									icon: "success",
									duration: 2000
								});
							} else {
								wx.showToast({
									title: "删除失败",
									icon: "none",
									duration: 2000
								});
							}
						})
						.catch(error => {
							console.log(error);
                            LOADFAIL();
						});
				} else if (res.cancel) {
					console.log("用户点击取消");
				}
			}
		});
	},
	// 获取搜索列表
	getList: function(page) {
		let that = this;
		if (page > last_page) {
			return false;
        }
        const data = {
            page: page + 1,
        }
		GET_SEARCH_LIST('GET',data)
			.then(res => {
				if (res.data) {
					that.setData({
						lists: [...that.data.lists, ...res.data.data],
						a_total: res.data.total
					});
					current_page = res.data.current_page;
					last_page = res.data.last_page;
				} else {
                    LOADFAIL();
				}
				wx.hideLoading();
				wx.hideNavigationBarLoading();
			})
			.catch(error => {
				console.log(error);
                LOADFAIL();
			});
	},
	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		this.getUserId();
		wx.showLoading({
			title: "加载中"
		});
		wx.setNavigationBarTitle({
			title: "搜索列表"
		});
		this.getList(0);
	},

	/**
	 * 页面相关事件处理函数--监听用户下拉动作
	 */
	onPullDownRefresh: function() {
		wx.showNavigationBarLoading();
		this.setData({
			lists: []
		});
		this.getList(0);
		wx.stopPullDownRefresh();
	},

	/**
	 * 页面上拉触底事件的处理函数
	 */
	onReachBottom: function() {
		this.getList(current_page);
	},

	/**
	 * 用户点击右上角分享
	 */
	onShareAppMessage: function() {}
});

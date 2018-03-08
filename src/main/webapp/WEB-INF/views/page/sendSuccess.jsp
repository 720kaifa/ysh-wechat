<html>
<body>
<h2>消息收到，关闭当前页面</h2>

<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>


<script type="text/javascript">
    _closeWindow();
    function _closeWindow() {
        if (typeof WeixinJSBridge == "undefined") {
            if (document.addEventListener) {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            } else if (document.attachEvent) {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    }

    function onBridgeReady() {
        WeixinJSBridge.call('closeWindow');
    }
</script>

</body>
</html>

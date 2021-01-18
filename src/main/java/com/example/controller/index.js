2021 - 01 - 12
16
:
38
:
01
.258 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.framework.dubbo.filter.PermitsFilter.invoke()
:
54 - dubboLimitRateEnable
is
false
method
is
com.smy.pcs.service.PayFacade.unifiedOrder
permitsPerSecond
is
null
2021 - 01 - 12
16
:
38
:
01
.264 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.router.dao.MerchantInfoMapper.selectById.debug()
:
159 - == > Preparing
:
SELECT
merchant_id
AS
merchantId, merchant_name
AS
merchantName, merchant_product
AS
merchantProduct, merchant_org
AS
merchantOrg, sms_strategy
AS
smsStrategy , `status`, default_flag
AS
defaultFlag, create_datetime
AS
createDatetime, update_datetime
AS
updateDatetime, created_by
AS
createdBy , updated_by
AS
updatedBy, remark
FROM
t_merchant_info
WHERE
merchant_id = ?
  2021 - 01 - 12 16
:
38
:
01
.266 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.router.dao.MerchantInfoMapper.selectById.debug()
:
159 - == > Parameters
:
axqy(String)
2021 - 01 - 12
16
:
38
:
01
.271 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.router.dao.MerchantInfoMapper.selectById.debug()
:
159 - <==      Total: 1
2021-01-12 16:38:01.276|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - ==>  Preparing: SELECT channel_id FROM t_channel_info WHERE channel_status = ? AND channel_product & ?
2021-01-12 16:38:01.280|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - ==> Parameters: valid(String), 1(Integer)
2021-01-12 16:38:01.285|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - < == Total
:
24
2021 - 01 - 12
16
:
38
:
01
.286 | INFO | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.framework.core.interceptor.ServiceInterceptor.invoke()
:
68 - 交易：ChannelInfoServiceImpl.selectByProduct
success , 耗时：13
ms
2021 - 01 - 12
16
:
38
:
01
.290 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || c.s.p.router.dao.MerchantChannelInfoNewMapper.selectList.debug()
:
159 - == > Preparing
:
SELECT
id
AS
id, merchant_id
AS
merchantId, merchant_name
AS
merchantName, capital_code
AS
capitalCode, channel_id
AS
channelId , channel_name
AS
channelName, channel_merchant_id
AS
channelMerchantId, channel_merchant_name
AS
channelMerchantName, `status`, validate_flag
AS
validateFlag , bind_merchant_id
AS
bindMerchantId, bind_channel_merchant_id
AS
bindChannelMerchantId, create_datetime
AS
createDatetime, update_datetime
AS
updateDatetime, created_by
AS
createdBy , updated_by
AS
updatedBy, remark
FROM
t_merchant_channel
WHERE
merchant_id = ? AND channel_id
IN(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
AND
status = ? ORDER BY
update_datetime
DESC
2021 - 01 - 12
16
:
38
:
01
.292 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || c.s.p.router.dao.MerchantChannelInfoNewMapper.selectList.debug()
:
159 - == > Parameters
:
axqy(String), AIBANKREPAY(String), ALIPAY_UNIT_ORDER(String), ALLINPAY(String), ALLINPAY2(String), ALLINPAYGATEWAY(String), ALLINPAYQUICK(String), ALLINPAY_UNIT_ORDER(String), APPLE_IAP(String), BAOFOO(String), BAOFOOQUICK(String), BFBFC(String), BFBQUICK(String), BILL99(String), BILL99QUICK(String), CPCN(String), CPCNQUICK(String), JDPAY(String), JDPAY_C_S_02(String), JXPAY(String), SUMPAY(String), WEIXIN(String), WEIXINSERVICE(String), WEIXINSERVICE_H5(String), YEEPAY(String), valid(String)
2021 - 01 - 12
16
:
38
:
01
.323 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || c.s.p.router.dao.MerchantChannelInfoNewMapper.selectList.debug()
:
159 - <==      Total: 2
2021-01-12 16:38:01.324|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：MerchantChannelInfoNewServiceImpl.findByMchAndChns success ,耗时：37ms
2021-01-12 16:38:01.325|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.router.service.impl.RouteHandlerImpl.findMerchantChannelsByNewTable():719 - 新系统中支持该商户的有效渠道个数：2 , 商户渠道：[{"id":2,"merchantId":"axqy","merchantName":"安心权益","capitalCode":"SMY","channelId":"ALIPAY_UNIT_ORDER","channelName":"支付宝统一支付","channelMerchantId":"2021002110665197","channelMerchantName":"大鱼海棠","status":"valid","validateFlag":"Y","createDatetime":1610092056000,"updateDatetime":1610418430000,"createdBy":"超级管理员","updatedBy":"超级管理员"},{"id":1,"merchantId":"axqy","merchantName":"安心权益","capitalCode":"SMY","channelId":"ALIPAY_UNIT_ORDER","channelName":"支付宝统一支付","channelMerchantId":"2021002117672057","channelMerchantName":"长沙大风口网络技术有限公司 ","status":"valid","validateFlag":"Y","createDatetime":1610086064000,"updateDatetime":1610355258000,"createdBy":"超级管理员","updatedBy":"超级管理员"}]
2021-01-12 16:38:01.328|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - ==>  Preparing: SELECT channel_id AS channelId, channel_name AS channelName, channel_status AS channelStatus, channel_config AS channelConfig, channel_payment AS channelPayment , channel_product AS channelProduct, verify_interaction AS verifyInteraction, pay_interaction AS payInteraction, need_sign AS needSign, diversion , create_datetime AS createDatetime, update_datetime AS updateDatetime, created_by AS createdBy, updated_by AS updatedBy, remark FROM t_channel_info WHERE channel_id IN (?, ?) AND channel_status = ? AND channel_product & 1
2021-01-12 16:38:01.330|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - ==> Parameters: ALIPAY_UNIT_ORDER(String), ALIPAY_UNIT_ORDER(String), valid(String)
2021-01-12 16:38:01.335|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectList.debug():159 - <==      Total: 1
2021-01-12 16:38:01.336|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：ChannelInfoServiceImpl.findByMap success ,耗时：11ms
2021-01-12 16:38:01.338|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.pcs.router.dao.ChannelMonitorRecordMapper.selectList.debug():159 - ==>  Preparing: SELECT id AS id, biz_type AS bizType, biz_sub_type AS bizSubType, channel_id AS channelId, channel_merchant_id AS channelMerchantId , bank_code AS bankCode, rule_type AS ruleType, group_id AS groupId, ref_value AS refValue, curr_value AS currValue , `status`, tick_times AS tickTimes, next_tick_interval AS nextTickInterval, next_tick_time AS nextTickTime, create_datetime AS createDatetime , update_datetime AS updateDatetime, created_by AS createdBy, updated_by AS updatedBy, remark FROM t_channel_monitor_record WHERE biz_type = ? AND channel_id IN (?, ?) AND status = ? AND next_tick_time > ? ORDER BY next_tick_time
2021-01-12 16:38:01.340|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.pcs.router.dao.ChannelMonitorRecordMapper.selectList.debug():159 - ==> Parameters: 01(String), ALIPAY_UNIT_ORDER(String), ALIPAY_UNIT_ORDER(String), FUSED(String), 2021-01-12 16:38:01.336(Timestamp)
2021-01-12 16:38:01.353|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.pcs.router.dao.ChannelMonitorRecordMapper.selectList.debug():159 - <==      Total: 1
2021-01-12 16:38:01.354|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：ChannelMonitorRecordServiceImpl.findByMap success ,耗时：18ms
2021-01-12 16:38:01.357|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.p.r.dao.MerchantChannelRouteConfigMapper.selectList.debug():159 - ==>  Preparing: SELECT id AS id, merchant_id AS merchantId, merchant_name AS merchantName, order_type AS orderType, channel_id AS channelId , channel_name AS channelName, channel_product AS channelProduct, channel_payment AS channelPayment, bank_code AS bankCode, bank_card_type AS bankCardType , route_type AS routeType, route_value AS routeValue, priority, `status`, create_datetime AS createDatetime , update_datetime AS updateDatetime, created_by AS createdBy, updated_by AS updatedBy, remark FROM t_merchant_channel_route_config WHERE merchant_id = ? AND bank_code IN (?, ?) AND channel_product & ? AND route_type = ? AND status = ? ORDER BY priority, update_datetime DESC
2021-01-12 16:38:01.359|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.p.r.dao.MerchantChannelRouteConfigMapper.selectList.debug():159 - ==> Parameters: axqy(String), all(String), 00000000(String), 1(Integer), 1(Integer), valid(String)
2021-01-12 16:38:01.364|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.p.r.dao.MerchantChannelRouteConfigMapper.selectList.debug():159 - <==      Total: 1
2021-01-12 16:38:01.365|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：RouteConfigServiceImpl.findListByMap success ,耗时：10ms
2021-01-12 16:38:01.366|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.router.handler.ProportionRouter.channelMerchantRouter():91 - availChannels : [{"merchantId":"axqy","channelId":"ALIPAY_UNIT_ORDER","channelMerchantId":"2021002117672057"}], config : RouteConfig(id=1015, bankCode=all, channelProduct=1, routeValue=[{"config":[{"channelId":"ALIPAY_UNIT_ORDER","channelMerchantRouteBeans":[{"channelMerchantId":"2021002110665197","proportion":50},{"channelMerchantId":"2021002117672057","proportion":50}]}]}], amount=1)
2021-01-12 16:38:01.366|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.router.util.ProportionUtil.getChannelMerchantRoutes():174 - 金额命中条件 ！将在符合这个条件内的渠道进行选择！null
2021-01-12 16:38:01.367|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.router.handler.ProportionRouter.channelMerchantFilter():123 - proportionBeanList : [{"channelId":"ALIPAY_UNIT_ORDER","channelMerchantRouteBeans":[{"channelMerchantId":"2021002110665197","proportion":50},{"channelMerchantId":"2021002117672057","proportion":50}]}]
2021-01-12 16:38:01.369|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectById.debug():159 - ==>  Preparing: SELECT channel_id AS channelId, channel_name AS channelName, channel_status AS channelStatus, channel_config AS channelConfig, channel_payment AS channelPayment , channel_product AS channelProduct, verify_interaction AS verifyInteraction, pay_interaction AS payInteraction, need_sign AS needSign, diversion , create_datetime AS createDatetime, update_datetime AS updateDatetime, created_by AS createdBy, updated_by AS updatedBy, remark FROM t_channel_info WHERE channel_id = ?
2021-01-12 16:38:01.371|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectById.debug():159 - ==> Parameters: ALIPAY_UNIT_ORDER(String)
2021-01-12 16:38:01.383|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.ChannelInfoMapper.selectById.debug():159 - <==      Total: 1
2021-01-12 16:38:01.384|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：ChannelInfoServiceImpl.selectByChannelId success ,耗时：17ms
2021-01-12 16:38:01.389|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.insert.debug():159 - ==>  Preparing: INSERT INTO t_trans_order_info ( trans_seqno, merchant_order_id, merchant_id, merchant_name, capital_code, channel_id, channel_name, trans_type, cust_no, bank_card_no, trans_amt, trans_desc, request_datetime, currency, id_no, route_type, signature, `status`, step_status, version, notify_url, notify_flag, query_count, channel_req_seqno ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
2021-01-12 16:38:01.394|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.insert.debug():159 - ==> Parameters: D210112001164000354(String), C482101120000650054(String), axqy(String), 安心权益(String), SMY(String), ALIPAY_UNIT_ORDER(String), 支付宝统一支付(String), 1(Integer), 160001060981(String), E_0000_0_AeBs1F4plXHp1FQxQWhg3Q==(String), 0.30(BigDecimal), 省呗会员半年卡(String), 2021-01-12 16:38:01.252(Timestamp), 156(String), E_0000_0_jBTbdwfv9y2U1li2g7Kn9A==(String), NONE(String), 593e0fdcda70035afef3a9b906aded81(String), PROCESSING(String), WAIT_QUERY(String), 0(Integer), mq:pcs-payResult(String), N(String), 0(Integer), C602101120011640003(String)
2021-01-12 16:38:01.403|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.insert.debug():159 - <==    Updates: 1
2021-01-12 16:38:01.415|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug():159 - ==>  Preparing: UPDATE t_trans_order_info SET channel_id=?, channel_name=?, channel_merchant_id=?, signature=?, `status`=?, step_status=?, version=?, query_count=?, channel_req_seqno=?, channel_req_datetime=? WHERE trans_seqno=? and version=?
2021-01-12 16:38:01.419|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug():159 - ==> Parameters: ALIPAY_UNIT_ORDER(String), 支付宝统一支付(String), 2021002117672057(String), cfa217385ae0a916004687cf0b16af2b(String), PROCESSING(String), WAIT_QUERY(String), 1(Integer), 0(Integer), D210112001164000354(String), 2021-01-12 16:38:01.412(Timestamp), D210112001164000354(String), 0(Integer)
2021-01-12 16:38:01.435|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug():159 - <==    Updates: 1
2021-01-12 16:38:01.436|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.s.p.r.service.impl.ChannelStandardClientServiceImpl.unifiedOrder():102 - 渠道请求信息:{"merchantId":"axqy","channelId":"ALIPAY_UNIT_ORDER","channelMerchantId":"2021002117672057","channelReqSeqno":"D210112001164000354","transAmt":0.30,"transDesc":"省呗会员半年卡","spbillCreateIp":"192.168.19.49","paymentType":"aliPayH5","quitUrl":"https://srm-sit-07.smyjf.cn/app/member_benefit/thirdPaymentResult?type=4&orderType=1&qd=gerenzhongxintest1&deliveryId=C032008260003010013&redirect_flag=1&uid=160001060981&token=8c98bab06d125b959bc80ffddffe9d10&merchantOrderId=C482101120000650054&transSeqno=C602101120011640003"}
2021-01-12 16:38:01.438|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.smy.pcs.dao.ChannelInfoMapper.getChannelMerchantConfig.debug():159 - ==>  Preparing: SELECT channel_merchant_config AS merchantConfig FROM t_channel_merchant_config WHERE channel_id = ? AND channel_merchant_id = ? AND `status` = ? LIMIT 1
2021-01-12 16:38:01.439|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.smy.pcs.dao.ChannelInfoMapper.getChannelMerchantConfig.debug():159 - ==> Parameters: ALIPAY_UNIT_ORDER(String), 2021002117672057(String), valid(String)
2021-01-12 16:38:01.451|DEBUG|DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||c.smy.pcs.dao.ChannelInfoMapper.getChannelMerchantConfig.debug():159 - < == Total
:
1
2021 - 01 - 12
16
:
38
:
01
.452 | INFO | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.framework.core.interceptor.ServiceInterceptor.invoke()
:
68 - 交易：ChannelInfoServiceImpl.getConfigInfo
success , 耗时：16
ms
2021 - 01 - 12
16
:
38
:
01
.512 | INFO | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.chn.client.AlipayUnitOrderClient.unifiedOrder()
:
141 - 支付宝响应
->
{
  "alipayTradeWapPayResponse"
:
  {
    "body"
  :
    "<form name=\"punchout_form\" method=\"post\" action=\"https://openapi.alipay.com/gateway.do?alipay_root_cert_sn=687b59193f3f462dd5336e5abf83c5d8_02941eef3187dddf3d3b83462e1dfcf6&alipay_sdk=alipay-easysdk-java-2.1.0&app_cert_sn=53c59b457f71ce6624c6c1df83970237&app_id=2021002117672057&charset=UTF-8&format=json&method=alipay.trade.wap.pay&notify_url=gateway.smyjf.cn%3A8077%2Fb2b-front%2Fcallback%2Fpayment%2Fnotify%2FALIPAY_UNIT_ORDER%2F2021002117672057&return_url=https%3A%2F%2Fsrm-sit-07.smyjf.cn%2Fapp%2Fmember_benefit%2FthirdPaymentResult%3Ftype%3D4%26orderType%3D1%26qd%3Dgerenzhongxintest1%26deliveryId%3DC032008260003010013%26redirect_flag%3D1%26uid%3D160001060981%26token%3D8c98bab06d125b959bc80ffddffe9d10%26merchantOrderId%3DC482101120000650054%26transSeqno%3DC602101120011640003&sign=o1uEU7OYLKYE7%2BW3VWkiDtcI83XCgs0bHLdG93r9w%2FthFRvFq6dGDZ7nIYftjwoQz%2Fca8DYq4exOu999ucu9cOP%2FTfw1mhtqlloHNjZhlni6t3jUJYi2gOjTjevlTHIzPY1hpOQvz11tLx3IIQ%2Fs7aQwomcIy8VXw6IR7udeSAkC5gL4PY8MRoiIu5tqwiXLILnhsyS1MV2A8k46jfuSTp49ZGpliDPC%2B1UoILR5Ldm6rWiFytExHrrgH4kLo0YWNEi90D08oDq8g9EKkO12Wjb8x%2BCzQMdITdiWcCnJ8XaKfrLDwbrSlLo1RgbLz7xhOTaFcw3VgqmjsM2k1CBtCg%3D%3D&sign_type=RSA2&timestamp=2021-01-12+16%3A38%3A01&version=1.0\">\n<input type=\"hidden\" name=\"biz_content\" value=\"{&quot;time_expire&quot;:&quot;2021-01-12 16:47:01&quot;,&quot;out_trade_no&quot;:&quot;D210112001164000354&quot;,&quot;total_amount&quot;:&quot;0.30&quot;,&quot;quit_url&quot;:&quot;https://srm-sit-07.smyjf.cn/app/member_benefit/thirdPaymentResult?type\\u003d4\\u0026orderType\\u003d1\\u0026qd\\u003dgerenzhongxintest1\\u0026deliveryId\\u003dC032008260003010013\\u0026redirect_flag\\u003d1\\u0026uid\\u003d160001060981\\u0026token\\u003d8c98bab06d125b959bc80ffddffe9d10\\u0026merchantOrderId\\u003dC482101120000650054\\u0026transSeqno\\u003dC602101120011640003&quot;,&quot;subject&quot;:&quot;省呗会员半年卡&quot;,&quot;product_code&quot;:&quot;QUICK_WAP_WAY&quot;}\">\n<input type=\"submit\" value=\"立即支付\" style=\"display:none\" >\n</form>\n<script>document.forms[0].submit();</script>"
  }
}
2021 - 01 - 12
16
:
38
:
01
.513 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || c.s.p.r.service.impl.ChannelStandardCodeCacheServiceImpl.getStandardCode()
:
115 - channelId = ALIPAY_UNIT_ORDER
standardType = 1
standCode = Pay - SUCCESS
2021 - 01 - 12
16
:
38
:
01
.523 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || c.s.pcs.router.service.impl.StandardCodeCacheServiceImpl.getStandardCode()
:
142 - Redis
影射关系
key:pcs.standardcode.status.standardType
:
1
field:PROCESSING
value:WAIT_QUERY
2021 - 01 - 12
16
:
38
:
01
.524 | INFO | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.framework.core.interceptor.ServiceInterceptor.invoke()
:
68 - 交易：PayFacadeHandlerImpl.getStepStatus
success , 耗时：6
ms
2021 - 01 - 12
16
:
38
:
01
.526 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug()
:
159 - == > Preparing
:
UPDATE
t_trans_order_info
SET
channel_merchant_id = ?, trans_datetime = ?, signature = ?, `status` = ?, step_status = ?, return_code = ?, return_info = ?, version = ?, query_count = ?, standard_code = ?, standard_msg = ? WHERE trans_seqno = ? and version = ?
  2021 - 01 - 12 16
:
38
:
01
.529 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug()
:
159 - == > Parameters
:
2021002117672057(String), 2021 - 01 - 12
16
:
38
:
01
.412(Timestamp), 112085408
aa45fb8a77324265a12cd0f(String), PROCESSING(String), WAIT_QUERY(String), Pay - SUCCESS(String), 生成订单表单成功(String), 2(Integer), 0(Integer), PROCESSING(String), 处理中(String), D210112001164000354(String), 1(Integer)
2021 - 01 - 12
16
:
38
:
01
.552 | DEBUG | DubboServerHandler - 192.168
.26
.80
:
20898 - thread - 9 | 7
abeaca1a6b4f2a9 | 192.168
.26
.80 || || com.smy.pcs.dao.TransOrderInfoMapper.updateById.debug()
:
159 - <==    Updates: 1
2021-01-12 16:38:01.553|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():30 - [MQ-SEND-BEIGN][发送普通消息MessageReq:topic=pcs-delayCollectionQuery，key=D210112001164000354，body={"businessKey":"D210112001164000354","delayLevel":{"executorCount":1,"interval":0,"rocketMqLevel":4},"executeCount":0,"params":"D210112001164000354"}，delayLevel=4].
2021-01-12 16:38:01.556|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():47 - 发送普通消息结束 。 SendResult is SendResult [sendStatus=SEND_OK, msgId=C0A81A50CF7F1B9E19163C37AC51001D, offsetMsgId=C0A81A5000002A9F0000000004863770, messageQueue=MessageQueue [topic=pcs-delayCollectionQuery, brokerName=broker-a, queueId=3], queueOffset=597]
2021-01-12 16:38:01.557|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():55 - [MQ-SEND-END][发送普通消息耗时: time=4 ms].
2021-01-12 16:38:01.557|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.pcs.mq.producer.CloseOrderProducer.push():36 - CloseOrderProducer topic : pcs-closeOrder, transSeqno : D210112001164000354
2021-01-12 16:38:01.558|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():30 - [MQ-SEND-BEIGN][发送普通消息MessageReq:topic=pcs-closeOrder，key=D210112001164000354，body=D210112001164000354，delayLevel=14].
2021-01-12 16:38:01.562|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():47 - 发送普通消息结束 。 SendResult is SendResult [sendStatus=SEND_OK, msgId=C0A81A50CF7F1B9E19163C37AC56001E, offsetMsgId=C0A81A5000002A9F00000000048638ED, messageQueue=MessageQueue [topic=pcs-closeOrder, brokerName=broker-a, queueId=4], queueOffset=2581]
2021-01-12 16:38:01.563|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.mq.client.util.NewMessageProducer.sendMsg():55 - [MQ-SEND-END][发送普通消息耗时: time=5 ms].
2021-01-12 16:38:01.563|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：TransOrderInfoServiceImpl.unifiedOrder success ,耗时：291ms
2021-01-12 16:38:01.564|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.framework.core.interceptor.ServiceInterceptor.invoke():68 - 交易：PayFacadeImpl.unifiedOrder success ,耗时：306ms
2021-01-12 16:38:01.566|INFO |DubboServerHandler-192.168.26.80:20898-thread-9|7abeaca1a6b4f2a9|192.168.26.80||||com.smy.smyx.rtm.client.interfaceCall.interfaceCallInner():248 - {"msgType":"interfaceCall","callCostTime":307,"consumerSysCode":"member-front","sysIp":"127.0.0.1","callResult":"success"}

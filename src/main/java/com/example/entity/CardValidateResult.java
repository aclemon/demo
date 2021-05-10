package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.aop.Condition;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 验卡结果表(CardValidateResult)表实体类
 *
 * @author makejava
 * @since 2021-04-20 15:19:14
 */
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_card_validate_result")
public class CardValidateResult extends Model<CardValidateResult> {
    private static final long serialVersionUID = 1L;

    /**
     * 认证ID，主键
     */
    @TableId(value = "cert_id", type = IdType.INPUT)
    private String certId;
    /**
     * 商户号，默认为SMYS
     */
    @TableField("merchant_id")
    private String merchantId;
    /**
     * 客户号
     */
    @TableField("cust_no")
    private String custNo;
    /**
     * 客户姓名，加密字段
     */
//    @TableField("cust_name")
    private String custName;
    /**
     * 证件类型，默认为01，身份证
     */
    @TableField("id_type")
    private String idType;
    /**
     * 证件编号，加密字段
     */
    @TableField("id_no")
    @Condition(group = "four")
    private String idNo;
    /**
     * 银行卡类型，默认为1（1-借记卡、2-贷记卡）
     */
    @TableField("bank_card_type")
    private Integer bankCardType;
    /**
     * 银行卡号，加密字段
     */
    @TableField("bank_card_no")
    @Condition(group = "four")
    private String bankCardNo;
    /**
     * 信用卡CVV2，加密字段
     */

    private String cvv;
    /**
     * 信用卡有效期，加密字段
     */
    @TableField("expiry_date")

    private String expiryDate;
    /**
     * 手机号，加密字段
     */
    @TableField("mobile_no")
    private String mobileNo;
    /**
     * 银行编码
     */
    @TableField("bank_code")
    private String bankCode;
    /**
     * 银行名称
     */
    @TableField("bank_name")
    private String bankName;
    /**
     * 验证类型，默认为01（01-绑卡验证、02-借款验证、03-还款验证、99-其他）
     */
    @TableField("valid_type")
    private String validType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 渠道号
     */
    @TableField("channel_id")
    private String channelId;
    /**
     * 渠道名称
     */
    @TableField("channel_name")
    private String channelName;
    /**
     * 渠道商户号
     */
    @TableField("channel_merchant_id")
    private String channelMerchantId;
    /**
     * 渠道请求流水号
     */
    @TableField("channel_req_seqno")
    private String channelReqSeqno;
    /**
     * 渠道银行编号
     */
    @TableField("channel_bank_code")
    private String channelBankCode;
    /**
     * 渠道令牌，即验卡短信发送时渠道返回的一个用于短信确认的标识。通常与channel_req_seqno相同，但部分渠道也会使用自己的标识
     */
    @TableField("channel_token")

    private String channelToken;
    /**
     * 协议号
     */
    @TableField("agreement")
    private String agreement;
    /**
     * 渠道预留字段1
     */
    @TableField("channel_standby1")
    private String channelStandby1;
    /**
     * 渠道预留字段2
     */
    @TableField("channel_standby2")
    private String channelStandby2;
    /**
     * 渠道预留字段3
     */
    @TableField("channel_standby3")
    private String channelStandby3;
    /**
     * 渠道预留字段4
     */
    @TableField("channel_standby4")
    private String channelStandby4;
    /**
     * 渠道返回代码
     */
    @TableField("return_code")
    private String returnCode;
    /**
     * 渠道返回信息
     */
    @TableField("return_msg")
    private String returnMsg;
    /**
     * 标准码
     */
    @TableField("standard_code")
    private String standardCode;
    /**
     * 标准码信息
     */
    @TableField("standard_msg")
    private String standardMsg;
    /**
     * 短信状态（00-初始、01-已发送短信,、02-短信发送异常、03-短信确认异常、04-认证完成、05-认证异常）
     */
    @TableField("sms_status")
    private String smsStatus;
    /**
     * 验证状态，标识验卡信息是否通过（00-无效、01-有效、02-客户解绑、03-系统解绑）
     */
    @TableField("verify_status")
    private String verifyStatus;
    /**
     * 验证方式
     * VARIFICATION_3("01", "三要素验卡"),
     * VARIFICATION_4("02", "四要素验卡"),
     */
    @TableField("valid_method")
    private String validMethod;
    /**
     * 乐观锁版本号
     */
    private Integer version;
    /**
     * 创建日期时间
     */
    @TableField("create_datetime")
    private Date createDatetime;
    /**
     * 最后修改日期时间
     */
    @TableField("update_datetime")
    private Date updateDatetime;
    /**
     * 商户请求流水
     */
    @TableField("mch_req_id")
    private String mchReqId;

    @Override
    protected Serializable pkVal() {
        return this.certId;
    }
}

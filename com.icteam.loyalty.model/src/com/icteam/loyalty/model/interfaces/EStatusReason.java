package com.icteam.loyalty.model.interfaces;

import com.icteam.loyalty.api.Api;
import com.icteam.loyalty.api.interfaces.ConverterClass;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.IStatusReason;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.api.interfaces.PropertyClass;

/**
 * This source file was created by ICTeam S.P.A.
 * <p/>
 * The software must not be used nor reproduced in any form without ICTeam and customer authorization
 * <p/>
 * Project : altyActivator Customer : ICTeam
 * <p/>
 * Author : $Author: d.pirola $ File : $HeadURL:
 * http://jolokia:1080/svn/ICTeam/Loyalty2.0/trunk/loyalty-interfaces/src/main/java/com/icteam/loyalty/interfaces/enums/EStatusReason.java $ Revision
 * : $Revision: 5008 $ Last Checkin: $Date: 2013-10-08 17:55:40 +0200 (Tue, 08 Oct 2013) $
 */
@PropertyClass(translateAll = true)
@ConverterClass
public class EStatusReason extends EnhancedEnum<EStatusReason, String> implements IStatusReason {

    private static final long serialVersionUID = -6861143723392509954L;

    public static final EStatusReason OK = new EStatusReason("OK", 0);
    public static final EStatusReason ERROR = new EStatusReason("ERROR", 1);;
    public static final EStatusReason OBJECT_UNKNOWN = new EStatusReason("OBJECT_UNKNOWN", 2);

    public static final EStatusReason MAX_LENGTH_IN_IN_CLAUSE_REACHED = new EStatusReason("MAX_LENGTH_IN_IN_CLAUSE_REACHED", 3);

    public static final EStatusReason REFERENCED_OBJECT_FOUND = new EStatusReason("REFERENCED_OBJECT_FOUND", 4);

    public static final EStatusReason CUSTOM_MESSAGE_ADD_ERROR = new EStatusReason("CUSTOM_MESSAGE_ADD_ERROR", 5);

    public static final EStatusReason DELEGATED_SERVICE_NOT_FOUND = new EStatusReason("DELEGATED_SERVICE_NOT_FOUND", 6);

    public static final EStatusReason MIN_CHARACTER_SEARCH_LENGTH = new EStatusReason("MIN_CHARACTER_SEARCH_LENGTH", 7);

    public static final EStatusReason CRON_EXPRESSION_INVALID = new EStatusReason("CRON_EXPRESSION_INVALID", 8);

    public static final EStatusReason SERVICE_NOT_FOUND = new EStatusReason("SERVICE_NOT_FOUND", 9);

    //    public static final EStatusReason NOT_AVAILABLE_POINTS = new EStatusReason("NOT_AVAILABLE_POINTS", 17);
//    public static final EStatusReason PROFILE_NOT_FOUND = new EStatusReason("PROFILE_NOT_FOUND", 31);
//    public static final EStatusReason STATUS_NOT_VALID = new EStatusReason("STATUS_NOT_VALID", 35);
//    public static final EStatusReason STATUS_TRANSITION_NOT_VALID = new EStatusReason("STATUS_TRANSITION_NOT_VALID", 36);
//    public static final EStatusReason UPGRADE_TO_NEXT_PROFILE_LEVEL = new EStatusReason("UPGRADE_TO_NEXT_PROFILE_LEVEL", 41);
//    public static final EStatusReason DOWNGRADE_PROFILE = new EStatusReason("DOWNGRADE_PROFILE", 43);
//    public static final EStatusReason INVALID_FORMAT = new EStatusReason("INVALID_FORMAT", 60);
//    public static final EStatusReason ENTRY_LEVEL_PROFILE_NOT_EXIST = new EStatusReason("ENTRY_LEVEL_PROFILE_NOT_EXIST", 70);
//    public static final EStatusReason PROFILE_INSERT_HIERARCHY_ALREADY_ASSOCIATED_USER = new EStatusReason("PROFILE_INSERT_HIERARCHY_ALREADY_ASSOCIATED_USER", 71);
//    public static final EStatusReason BATCH_INPUT_PROCESSING_ERROR = new EStatusReason("BATCH_INPUT_PROCESSING_ERROR", 100);
//    public static final EStatusReason BATCH_STILL_RUNNING = new EStatusReason("BATCH_STILL_RUNNING", 101);
//    public static final EStatusReason BATCH_INPUT_ALREADY_PROCESSED = new EStatusReason("BATCH_INPUT_ALREADY_PROCESSED", 102);
//    public static final EStatusReason BATCH_INPUT_NOT_FOUND = new EStatusReason("BATCH_INPUT_NOT_FOUND", 103);
//    public static final EStatusReason BATCH_INPUT_INVALID = new EStatusReason("BATCH_INPUT_INVALID", 104);
//    public static final EStatusReason BATCH_CONFIGURATION_ERROR = new EStatusReason("BATCH_CONFIGURATION_ERROR", 110);
//    public static final EStatusReason BATCH_OUTPUT_ERORR = new EStatusReason("BATCH_OUTPUT_ERORR", 111);
//    public static final EStatusReason UNKNOWN_PROCESS = new EStatusReason("UNKNOWN_PROCESS", 114);
//    public static final EStatusReason MISSING_PARAM = new EStatusReason("MISSING_PARAM", 116);
//    public static final EStatusReason DB_ERROR = new EStatusReason("DB_ERROR", 200);
//    public static final EStatusReason ERROR = new EStatusReason("ERROR", 201);
//    public static final EStatusReason ARGUMENT_NULL = new EStatusReason("ARGUMENT_NULL", 202);
//    public static final EStatusReason MEMBER_PROFILE_DEACTIVATE_BY_ADMIN = new EStatusReason("MEMBER_PROFILE_DEACTIVATE_BY_ADMIN", 204);
//    public static final EStatusReason SERVICE_RETRIEVE_ERROR = new EStatusReason("SERVICE_RETRIEVE_ERROR", 207);
//    public static final EStatusReason ALGORITHM_PARAM_NOT_FOUND = new EStatusReason("ALGORITHM_PARAM_NOT_FOUND", 300);
//    public static final EStatusReason DELEGATED_CLASS_NOT_VALID = new EStatusReason("DELEGATED_CLASS_NOT_VALID", 305);
//    public static final EStatusReason ACTIVATION_DATE_NOT_VALID = new EStatusReason("ACTIVATION_DATE_NOT_VALID", 306);
//    public static final EStatusReason REVOKE_REWARD_REQUEST_FROM_OPERATOR = new EStatusReason("REVOKE_REWARD_REQUEST_FROM_OPERATOR", 401);
//    public static final EStatusReason REWARD_REQUEST_NOT_FOUND = new EStatusReason("REWARD_REQUEST_NOT_FOUND", 415);
//    public static final EStatusReason REWARD_POLICY_NOT_FOUND = new EStatusReason("REWARD_POLICY_NOT_FOUND", 439);
//    public static final EStatusReason REWARD_BOUQUET_IN_USE = new EStatusReason("REWARD_BOUQUET_IN_USE", 440);
//    public static final EStatusReason REWARD_NOT_FOUND = new EStatusReason("REWARD_NOT_FOUND", 441);
//    public static final EStatusReason PRIVACY_FLAG_SET_TO_N = new EStatusReason("PRIVACY_FLAG_SET_TO_N", 505);
//    public static final EStatusReason VOUCHER_NOT_APPLIED_PRODUCT_NOT_FOUND = new EStatusReason("VOUCHER_NOT_APPLIED_PRODUCT_NOT_FOUND", 550);
//    public static final EStatusReason VOUCHER_NOT_APPLIED_PRODUCT_NOT_ENOUGH = new EStatusReason("VOUCHER_NOT_APPLIED_PRODUCT_NOT_ENOUGH", 551);
//    public static final EStatusReason VOUCHER_NOT_APPLIED_SPENDING_NOT_ENOUGH = new EStatusReason("VOUCHER_NOT_APPLIED_SPENDING_NOT_ENOUGH", 552);
//    public static final EStatusReason VOUCHER_NOT_FOUND = new EStatusReason("VOUCHER_NOT_FOUND", 554);
//    public static final EStatusReason VOUCHER_EXPIRED_OR_REDEEMED = new EStatusReason("VOUCHER_EXPIRED_OR_REDEEMED", 556);
//    public static final EStatusReason LOGIN_OR_PASSWORD_INCORRECT = new EStatusReason("LOGIN_OR_PASSWORD_INCORRECT", 600);
//    public static final EStatusReason FILE_NOT_FOUND = new EStatusReason("FILE_NOT_FOUND", 601);
//    public static final EStatusReason FILE_ALREADY_EXISTS = new EStatusReason("FILE_ALREADY_EXISTS", 602);
//    public static final EStatusReason INVALID_DESTINATION_PATH = new EStatusReason("INVALID_DESTINATION_PATH", 603);
//    public static final EStatusReason ACTION_NOT_FOUND = new EStatusReason("ACTION_NOT_FOUND", 604);
//    public static final EStatusReason CARD_NOT_FOUND = new EStatusReason("CARD_NOT_FOUND", 700);
//    public static final EStatusReason HIERARCHY_OVERLAP = new EStatusReason("HIERARCHY_OVERLAP", 800);
//    public static final EStatusReason HIERARCHICAL_TYPE_INVALID = new EStatusReason("HIERARCHICAL_TYPE_INVALID", 802);
//    public static final EStatusReason HIERARCHY_LOOP = new EStatusReason("HIERARCHY_LOOP", 803);
//    public static final EStatusReason NODE_UNKNOWN = new EStatusReason("NODE_UNKNOWN", 807);
//    public static final EStatusReason CODE_DUPLICATED = new EStatusReason("CODE_DUPLICATED", 808);
//    public static final EStatusReason PRODUCT_UNKNOWN = new EStatusReason("PRODUCT_UNKNOWN", 836);
//    public static final EStatusReason OPERATOR_NOT_FOUND = new EStatusReason("OPERATOR_NOT_FOUND", 900);
//    public static final EStatusReason WRONG_PASSWORD = new EStatusReason("WRONG_PASSWORD", 901);
//    public static final EStatusReason OPERATOR_IS_NOT_VALID = new EStatusReason("OPERATOR_IS_NOT_VALID", 902);
//    public static final EStatusReason OPERATOR_LOGIN_EXIST = new EStatusReason("OPERATOR_LOGIN_EXIST", 918);
//    public static final EStatusReason NO_MGM_PROGRAM_ACTIVE = new EStatusReason("NO_MGM_PROGRAM_ACTIVE", 921);
//    public static final EStatusReason OVERLAPPING_MGM_PROGRAMS = new EStatusReason("OVERLAPPING_MGM_PROGRAMS", 923);
//    public static final EStatusReason PASSWORD_ALREADY_USED = new EStatusReason("PASSWORD_ALREADY_USED", 924);
//    public static final EStatusReason OVERLAPPING_CREDIT_VALIDITIES = new EStatusReason("OVERLAPPING_CREDIT_VALIDITIES", 925);
//    public static final EStatusReason PASSWORD_MUST_BE_CHANGED = new EStatusReason("PASSWORD_MUST_BE_CHANGED", 926);
//    public static final EStatusReason REMOTE_LINK_NOT_ACTIVE = new EStatusReason("REMOTE_LINK_NOT_ACTIVE", 999);
//
//    /* Per i nuovi LaTwo ci mettiamo qui! */
//    public static final EStatusReason CRON_EXPRESSION_INVALID = new EStatusReason("CRON_EXPRESSION_INVALID", 2000);
//    public static final EStatusReason PARAM_INVALID = new EStatusReason("PARAM_INVALID", 2001);
//    public static final EStatusReason MEMBER_ALREADY_REGISTERED = new EStatusReason("MEMBER_ALREADY_REGISTERED", 2002);
//    public static final EStatusReason CARD_ALREADY_REGISTERED = new EStatusReason("CARD_ALREADY_REGISTERED", 2003);
//    public static final EStatusReason REWARD_BOUQUET_EMPTY = new EStatusReason("REWARD_BOUQUET_EMPTY", 2005);
//    public static final EStatusReason REWARD_MUST_BE_A_BOUQUET = new EStatusReason("REWARD_MUST_BE_A_BOUQUET", 2006);
//    public static final EStatusReason CREDIT_OPERATION_NOT_FOUND = new EStatusReason("CREDIT_OPERATION_NOT_FOUND", 2007);
//    public static final EStatusReason MEMBER_PROFILE_NOT_FOUND = new EStatusReason("MEMBER_PROFILE_NOT_FOUND", 2008);
//    public static final EStatusReason RECEIPT_LINE_NOT_FOUND = new EStatusReason("RECEIPT_LINE_NOT_FOUND", 2009);
//    public static final EStatusReason MEMBER_NOT_IN_CIRCULARITY = new EStatusReason("MEMBER_NOT_IN_CIRCULARITY", 2010);
//    public static final EStatusReason RECEIPT_NOT_FOUND = new EStatusReason("RECEIPT_NOT_FOUND", 2011);
//    public static final EStatusReason ACTION_ERROR = new EStatusReason("ACTION_ERROR", 2012);
//    public static final EStatusReason TRANSACTION_ALREADY_REGISTERED = new EStatusReason("TRANSACTION_ALREADY_REGISTERED", 2013);
//    public static final EStatusReason MEMBER_WITH_NO_LOGIN = new EStatusReason("MEMBER_WITH_NO_LOGIN", 2014);
//    public static final EStatusReason VOUCHER_MODEL_NOT_FOUND = new EStatusReason("VOUCHER_MODEL_NOT_FOUND", 2015);
//    public static final EStatusReason INVALID_PROMO_CODE = new EStatusReason("INVALID_PROMO_CODE", 2016);
//    public static final EStatusReason INVENTORY_PARAM_NODE_REWARD_ALREADY_PRESENT = new EStatusReason("INVENTORY_PARAM_NODE_REWARD_ALREADY_PRESENT", 2017);
//    public static final EStatusReason PROPERTY_ALREADY_EXISTS = new EStatusReason("PROPERTY_ALREADY_EXISTS", 2018);
//    public static final EStatusReason MEMBER_REGISTERED_WITH_DIFFERENT_NODE = new EStatusReason("MEMBER_REGISTERED_WITH_DIFFERENT_NODE", 2019);
//    public static final EStatusReason MEMBER_PROFILE_DEACTIVATE_BY_DYN_CRITERIA = new EStatusReason("MEMBER_PROFILE_DEACTIVATE_BY_DYN_CRITERIA", 2020);
//    public static final EStatusReason NOTIFICATION_NOT_FOUND = new EStatusReason("NOTIFICATION_NOT_FOUND", 2021);
//    public static final EStatusReason MEMBER_DEVICE_NOT_PRESENT = new EStatusReason("MEMBER_DEVICE_NOT_PRESENT", 2022);
//
//    public static final EStatusReason MESSAGE_WRITE_ERROR = new EStatusReason("MESSAGE_WRITE_ERROR", 4202);
//    public static final EStatusReason EMAIL_CHANNEL_CONNECTION_ERROR = new EStatusReason("EMAIL_CHANNEL_CONNECTION_ERROR", 4308);
//    public static final EStatusReason EMAIL_CHANNEL_COMMUNICATION_ERROR = new EStatusReason("EMAIL_CHANNEL_COMMUNICATION_ERROR", 4309);
//    public static final EStatusReason REPORT_NODE_NOT_FOUND = new EStatusReason("REPORT_NODE_NOT_FOUND", 1000);

    // LOYALTY_CARD_DOES_NOT_EXIST(2), PHYSICAL_CARD_DOES_NOT_EXIST(3), SUBSCRIBER_DOES_NOT_EXIST(4), LOYALTY_CARD_DEACTIVE(5),
    // PHYSICAL_CARD_DEACTIVE(6), SUBSCRIBER_DEACTIVE(
    // 7), LOYALTY_CARD_SUSPENDED(8), PHYSICAL_CARD_SUSPENDED(9), SUBSCRIBER_SUSPENDED(10), NOT_EXIST_CREDIT_SCORE(11), NOT_EXIST_LOYALTY_ENTITY(12),
    // CARD_NOT_ACTIVE_OR_SUSPENDED(13), OWNER_NOT_ACTIVE_AND_NOT_SUSPENDED(14), PROFILE_NOT_ACTIVE_AND_NOT_SUSPENDED(15), INVALID_OPERATION_TYPE(16),
    // NOT_BUNCHS_FOR_CARD(18), DIFFERENT_RESIDUAL_CREDITS(19), BUNCH_NOT_DELETE(20), NOT_EXIST_OPERATION_FOR_THIS_REWARD_REQUEST_ID(21),
    // START_DATE_AFTER_END_DATE(22),
    // ACCOUNTNUMBER_IS_ASSOCIATED_TO_A_DIFFERENT_CARD(23), DUNNING(24), CARD_NOT_ACTIVE_AND_NOT_SUSPENDED(25),
    // NOT_EXIST_CREDIT_FORCED_REASON_TYPE(26), INSERT_FORCED_REASON(27),
    // UNSUBSCRIBE(28), ACCOUNT_WITH_NO_CARD(29), RECEDING_LOYALTY_PROGRAM(30),
    // LOY_EVENT_LOG_NOT_FOUND(32), LOY_REJECTED_LOG_NOT_FOUND(33),
    // UNSUBSCRIBE_DUE_TO_CLIENT_CEASE(34), PROFILE_UPGRADE_POLICY_INVALID(42), PASS_TO_OTHER_PROFILE(44), DEACTIVATION_BY_SUBSTITUTION(50),
    // ACCOUNT_REMOVAL_REQUEST(51), ACCOUNT_DEACTIVATION_REQUEST(52), ACCOUNT_MOVE_REQUEST(53),
    // STATUS_REASON_CARD_LOST_BY_ADMIN(105),
    // STATUS_REASON_CARD_ACTIVE_BY_ADMIN(106), STATUS_REASON_CARD_SUSPENDED_BY_ADMIN(107), STATUS_REASON_CARD_FREEZE_BY_ADMIN(108),
    // STATUS_REASON_CARD_DEACTIVATE_BY_ADMIN(109),
    // PROCESSOR_CLASS_ERROR(112), HOST_NAME_ERROR(113), STATUS_REASON_CARD_OUTGOING_BY_ADMIN(115), TOO_MUCH_PARAM(117),
    // CARD_PROFILE_UPGRADE_DOES_NOT_EXIST(203), REMOTE_ERROR(206),
    // MORE_THAN_ONE_OBJECT(208), NOT_EXISTS_CHANNEL(209), NON_EXISTENT_OBJECT(210), ALGORITHM_NOT_VALID(301), PROFILE_POLICY_NOT_FOUND(302),
    // CREDIT_RULE_SET_NOT_VALID(303), NO_VALID_RULE_FOUND(304),
    // NOT_EXIST_MOVEMENT(308), CREDIT_SCORE_IS_ZERO(309), CREDIT_RULE_SET_NOT_FOUND(310), CREDIT_RULE_SET_IN_USE_IN_POLICY(311), CREDIT_RULE_IN_USE(
    // 312), CREDIT_RULE_NOT_FOUND(313), CREDIT_RULE_SET_IN_USE_IN_RULE(314), PROFILE_POLICY_IN_USE(315), ALGORITHM_IN_USE_IN_RULE(316),
    // ALGORITHM_NOT_FOUND(317),
    // PROFILE_POLICY_ALREADY_EXIST(318), ANTICIPATED_ACTIVE(319), NOT_DELETE_BUNCH_IS_EVEN_UP(320), TYPOLOGY_POINTS_NOT_ALLOWED(321),
    // SET_SCHEDULED_EVENT(322),
    // REWARD_BOUQUET_NOT_FOUND(400), REVOKE_REWARD_REQUEST_FROM_SUBSCRIBE(402), REWARD_REQUEST_IS_NOT_REJECTABLE(405),
    // REWARD_REQUEST_PROVISIONING_FAILED(410), REWARD_REQUEST_ITEM_NOT_FOUND(420), REWARD_REQUEST_STATUS_TYPE_NOT_FOUND(430),
    // REWARD_REQUEST_ITEM_STATUS_TYPE_NOT_FOUND(435), REWARD_ITEM_NOT_FOUND(436), REWARD_POLICY_ALREADY_EXIST(437), REWARD_ITEM_IN_USE(438),
    // REWARD_RANGE_NOT_FOUND(441), REWARD_RANGE_IN_USE(442), REWARD_ITEM_STATUS_NOT_ALLOWED(443), REWARD_STATUS_NOT_ALLOWED(444),
    // REWARD_CATALOG_ALREADY_IN_USE(445), OWNER_NOT_FOUND(703), LOYALTY_OWNER_ALREADY_EXISTS(501), NEW_STATUS_NOT_ALLOWED_FOR_OWNER(502),
    // LOYALTY_OWNER_TO_UPDATE_IS_NOT_VALID(503),
    // EMAIL_ALREADY_REGISTERED(506), INVALID_EMAIL(507), VOUCHER_TEMPLATE_NOT_VALID(553), VOUCHER_NOT_FOUND(554), VOUCHER_POLICY_NOT_FOUND(555),
    // VOUCHER_NOT_YET_VALID(557),
    // ACTION_STATUS_INVALID(
    // 605), ACTION_FILE_ALREADY_ASSOCIATED(606), ACTION_FILE_NOT_ASSOCIATED(607), ACTION_FILE_STATUS_INVALID(608), ACTION_FILE_NOT_FOUND(609),
    // ACTION_QUALIFIER_NOT_FOUND(610), FILE_FORMAT_INVALID(611), SUPPORT_REQUIRED(666),OWNER_STATUS_IS_DUNNING(701),
    // OWNER_CARD_ALREADY_EXISTING(702),
    // NOT_EXISTS_ENTRY_PROFILE(704), NEW_STATUS_CARD_NOT_ALLOWED(705), PHYSICAL_CARD_ALREADY_EXISTS(709), LAST_ENTITY_ACCOUNT(710),
    // NOT_EXISTS_NOTIFICATION_CHANNEL(711),
    // NOT_EXISTS_CARD_PROFILE(712), ENTITY_HAS_ALREADY_A_CARD(713), NODE_TYPE_UNMODIFIABLE(801), OPERATOR_NODE_DUPLICATED(804),
    // NODE_HIERARCHY_CHILD_FOUND(805), NODE_TYPE_HAS_LINKED_NODE(806),
    // PRODUCT_OVERLAP(830),
    // PRODUCT_TYPE_UNMODIFIABLE(831), PRODUCT_TYPE_INVALID(832), PRODUCT_HIERARCHY_LOOP(833), PRODUCT_HIERARCHY_CHILD_FOUND(834),
    // PRODUCT_TYPE_HAS_LINKED_PRODUCT(835),
    // POS_TYPE_UNKNOWN(850), POS_UNKNOWN(851), OPERATOR_IS_INACTIVE(903),
    // OPERATOR_STATUS_NOT_FOUND(904), OPERATOR_GROUP_NOT_FOUND(905), OPERATOR_GROUP_IS_NOT_VALID(906), OPERATOR_GROUP_STATUS_NOT_FOUND(907),
    // OPERATOR_GROUP_IS_INACTIVE(908),
    // GROUP_NOT_FOUND(909), GROUP_REALM_NOT_FOUND(910), GROUP_REALM_IS_NOT_VALID(911), GROUP_REALM_STATUS_NOT_FOUND(912),
    // GROUP_REALM_IS_INACTIVE(913), REALM_NOT_FOUND(914),
    // REALM_IS_NOT_VALID(915), REALM_STATUS_NOT_FOUND(916), REALM_IS_INACTIVE(917),PASSWORD_STRENGTH_KO(919), EMAIL_NOT_FOUND(920),
    // INVALID_INVITATION_CODE(922), ,
    //
    //
    // CARD_STATUS_CHANGED_BY_ADMIN(2004),
    //
    //
    // MANDATORY_PARAMETER_ERROR(4001), COMPATIBILITY_ERROR(4002), MISMATCH_CHANNEL_ERROR(4003), SYSTEM_UNKNOW(4004), NOT_MOVE_FILE(4005),
    // USER_ALREADY_EXISTS(4010), USER_NOT_FOUND(
    // 4011), USER_ATTR_PROPERTY_NOT_FOUND(4012), PROPERTY_ALREADY_EXISTS(4020), PROPERTY_NOT_FOUND(4021), NOTIFICATION_NOT_FOUND(4030),
    // NOTIFICATION_NOT_CREATED(4031),
    // NOTIFICATION_TYPE_NOT_FOUND(4040), NOTIFICATION_TYPE_NOT_CREATED(4041), NOTIFICATION_TYPE_NOT_ACTIVE(4042),
    // NOTIFICATION_GROUP_ALREADY_EXISTS(4050),
    // NOTIFICATION_GROUP_NOT_FOUND(4051), NOTIFICATION_TYPE_CH_NOT_FOUND(4060), NOTIFICATION_TYPE_CH_NOT_CREATED(4061),
    // NOTIFICATION_MSG_TEMPLATE_NOT_FOUND(4070),
    // NOTIFICATION_MSG_TEMPLATE_NOT_CREATED(4071), CHANNEL_ALREADY_EXISTS(4080), CHANNEL_NOT_FOUND(4081), MACRO_CHANNEL_ALREADY_EXISTS(4090),
    // MACRO_CHANNEL_NOT_FOUND(4091),
    // TEMPLATE_NOT_FOUND(4100), TEMPLATE_READ_ERROR(4101), TEMPLATE_WRITE_ERROR(4102), MESSAGE_NOT_FOUND(4200), MESSAGE_READ_ERROR(4201),
    // NOTIFICATION_LIST_NOT_FOUND(4300), TOO_NOTIFICATION_TYPE_FOR_THIS_NOTIFICATION_LIST(4301), NOTIFICATION_LIST_FILE_NOT_FOUND(4302),
    // NOTIFICATION_LIST_FILE_ALREADY_LOADED(4303),
    // INVALID_NOTIFCATION_LIST_STATUS(4304), INVALID_NOTIFCATION_LIST_FILE_STATUS(4305), NOTIFICATION_LIST_MEMEBER_ALREADY_LOADED(4306),
    // MORE_THAN_ONE_TEMPLATE_FOR_LIST(4307),
    // EMAIL_CHANNEL_MESSAGE_PARSE_ERROR(4310),
    // ;

    @Property(translatable = false)
    private Integer code;

    @Property(translatable = false)
    private String pluginId;

    static {
        OK.name();
    }

    public EStatusReason() {
        super();
    }

    /**
     * Costruttore
     *
     * @param code
     *            codice del StatusReason
     */
    public EStatusReason(String name, int code) {
        this(name, Api.ID, code);
    }

    public EStatusReason(String name, String pluginId, int code) {
        super(name);

        this.pluginId = pluginId;
        this.code = code;
    }

    @Override
    public String getPluginId() {
        return pluginId;
    }

    /**
     * @return il valore della variabile code di tipo PsiType:Integer.
     */
    @Override
    public Integer getCode() {
        return code;
    }

//    /**
//     * Ritorno EStatusReason dal codice di Status Reason
//     *
//     * @param code
//     *            codice di Status Reason
//     * @return EStatusReason
//     */
//    public static EStatusReason valueOf(Integer code) {
//        for (EStatusReason statusReason : EnhancedEnum.values(EStatusReason.class)) {
//            if (code.equals(statusReason.getCode())) {
//                return statusReason;
//            }
//        }
//
//        return null;
//    }

    @Override
    public String toString() {
        return name() + '(' + code + ')';
    }

}

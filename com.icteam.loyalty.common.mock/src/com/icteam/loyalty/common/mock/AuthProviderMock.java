// package com.icteam.loyalty.common.mock;
//
// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// import javax.sql.DataSource;
//
// import org.apache.commons.lang3.BooleanUtils;
// import org.apache.commons.lang3.StringUtils;
// import org.osgi.service.component.annotations.Reference;
//
// import com.icteam.loyalty.common.dto.OperatorDTO;
// import com.icteam.loyalty.common.dto.OperatorLoginDTO;
// import com.icteam.loyalty.common.dto.OperatorSearchDTO;
// import com.icteam.loyalty.common.interfaces.IGroup;
// import com.icteam.loyalty.common.model.Operator;
// import com.icteam.loyalty.common.service.AuthService;
// import com.icteam.loyalty.common.service.DTOService;
// import com.icteam.loyalty.common.service.EnumService;
// import com.querydsl.core.Tuple;
// import com.querydsl.sql.Configuration;
// import com.querydsl.sql.SQLQueryFactory;
//
//// @Component(property = { Constants.SERVICE_RANKING + ":Integer=100",
// "mock:Boolean=true" })
// public class AuthProviderMock implements AuthService {
//
// @Reference
// private DTOService dtoService;
//
// @Reference
// private EnumService enumService;
//
// @Reference
// private DataSource dataSource;
//
// @Reference
// private Configuration configuration;
//
// @Reference(target = "(!(mock=true))")
// private AuthService realAuthService;
//
// @Override
// public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
// final SQLQueryFactory queryFactory = new SQLQueryFactory(configuration,
// dataSource);
//
// final Operator o = new Operator("o");
// final Tuple tuple =
// queryFactory.select(o.all()).from(o).where(o.login.eq("manager")).fetchOne();
//
// final OperatorDTO operatorDTO = dtoService.newDTO(OperatorDTO.class);
// operatorDTO.setChangePassword(BooleanUtils.toBooleanObject(tuple.get(o.changePassword)));
// operatorDTO.setLogin(tuple.get(o.login));
// operatorDTO.setName(tuple.get(o.name));
// operatorDTO.setSurname(tuple.get(o.surname));
//
// final String[] groups =
// StringUtils.split(StringUtils.defaultString(tuple.get(o.groups)), ",");
// operatorDTO.setGroups(
// Stream.of(groups).map(group -> enumService.value(IGroup.class,
// group)).collect(Collectors.toList()));
//
// return operatorDTO;
//
// }
//
// @Override
// public List<OperatorDTO> search(OperatorSearchDTO operatorSearchDTO) {
// return realAuthService.search(operatorSearchDTO);
// }
//
// }

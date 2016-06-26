package com.icteam.loyalty.common.internal.provider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.dto.GroupDTO;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.enums.EStatus;
import com.icteam.loyalty.common.internal.Messages;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.CryptService;
import com.icteam.loyalty.common.service.DTOService;
import com.querydsl.core.Tuple;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.SQLQueryFactory;

@Component
public class AuthProvider implements AuthService {

	@Reference
	private CryptService cryptService;

	@Reference
	private DTOService dtoService;

	@Reference
	private DataSource dataSource;

	@Reference
	private Configuration configuration;

	@Override
	public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
		final SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, dataSource);

		final String encryptPassword = cryptService.encrypt(operatorLoginDTO.password);

		final Operator o = new Operator("o");
		final Tuple tuple = queryFactory.select(o.all()).from(o).where(o.login.eq(operatorLoginDTO.login))
				.where(o.password.eq(encryptPassword)).where(o.status.eq(EStatus.ATTIVO.name())).fetchOne();

		assert tuple != null : Messages.get().operator_not_found;

		final OperatorDTO operatorDTO = dtoService.newDTO(OperatorDTO.class);
		operatorDTO.changePassword = BooleanUtils.toBooleanObject(tuple.get(o.changePassword));
		operatorDTO.login = tuple.get(o.login);
		operatorDTO.name = tuple.get(o.name);
		operatorDTO.surname = tuple.get(o.surname);

		final String[] groups = StringUtils.split(StringUtils.defaultString(tuple.get(o.groups)), ",");
		operatorDTO.groups = Stream.of(groups).map(group -> {
			final GroupDTO groupDTO = new GroupDTO();
			groupDTO.group = group;

			return groupDTO;
		}).collect(Collectors.toList());

		return operatorDTO;
	}

}

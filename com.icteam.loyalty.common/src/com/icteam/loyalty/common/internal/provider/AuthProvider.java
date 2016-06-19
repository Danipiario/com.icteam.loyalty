package com.icteam.loyalty.common.internal.provider;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.CryptService;
import com.icteam.loyalty.common.service.DTOService;
import com.querydsl.core.Tuple;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.OracleTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;

@Component
public class AuthProvider implements AuthService {

	@Reference
	private CryptService cryptService;

	@Reference
	private DTOService dtoService;

	@Reference(cardinality = ReferenceCardinality.OPTIONAL)
	private DataSource dataSource;

	@Override
	public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
		final SQLTemplates templates = new OracleTemplates();
		final Configuration configuration = new Configuration(templates);

		final SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, dataSource);

		final String encryptPassword = cryptService.encrypt(operatorLoginDTO.password);

		final Operator operator = new Operator("");
		final Tuple tuple = queryFactory.select().where(operator.login.eq(operatorLoginDTO.login))
				.where(operator.password.eq(encryptPassword)).fetchOne();
		System.out.println(tuple);

		return dtoService.toDTO(operator, OperatorDTO.class);
	}

}

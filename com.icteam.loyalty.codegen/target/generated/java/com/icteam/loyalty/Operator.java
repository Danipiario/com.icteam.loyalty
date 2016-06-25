package com.icteam.loyalty;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Operator is a Querydsl query type for Operator
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class Operator extends com.querydsl.sql.RelationalPathBase<Operator> {

    private static final long serialVersionUID = 731329174;

    public static final Operator operator = new Operator("OPERATOR");

    public final NumberPath<Byte> changePassword = createNumber("changePassword", Byte.class);

    public final StringPath groups = createString("groups");

    public final StringPath login = createString("login");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath status = createString("status");

    public final StringPath surname = createString("surname");

    public final com.querydsl.sql.PrimaryKey<Operator> operatorPk = createPrimaryKey(login);

    public Operator(String variable) {
        super(Operator.class, forVariable(variable), "LOYALTY", "OPERATOR");
        addMetadata();
    }

    public Operator(String variable, String schema, String table) {
        super(Operator.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Operator(Path<? extends Operator> path) {
        super(path.getType(), path.getMetadata(), "LOYALTY", "OPERATOR");
        addMetadata();
    }

    public Operator(PathMetadata metadata) {
        super(Operator.class, metadata, "LOYALTY", "OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(changePassword, ColumnMetadata.named("CHANGE_PASSWORD").withIndex(5).ofType(Types.DECIMAL).withSize(1));
        addMetadata(groups, ColumnMetadata.named("GROUPS").withIndex(6).ofType(Types.VARCHAR).withSize(2000));
        addMetadata(login, ColumnMetadata.named("LOGIN").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(50));
        addMetadata(password, ColumnMetadata.named("PASSWORD").withIndex(4).ofType(Types.VARCHAR).withSize(50));
        addMetadata(status, ColumnMetadata.named("STATUS").withIndex(7).ofType(Types.VARCHAR).withSize(50));
        addMetadata(surname, ColumnMetadata.named("SURNAME").withIndex(3).ofType(Types.VARCHAR).withSize(50));
    }

}


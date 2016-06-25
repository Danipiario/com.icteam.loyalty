package com.icteam.loyalty;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * Databasechangeloglock is a Querydsl query type for Databasechangeloglock
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class Databasechangeloglock extends com.querydsl.sql.RelationalPathBase<Databasechangeloglock> {

    private static final long serialVersionUID = 640821874;

    public static final Databasechangeloglock databasechangeloglock = new Databasechangeloglock("DATABASECHANGELOGLOCK");

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final NumberPath<Byte> locked = createNumber("locked", Byte.class);

    public final StringPath lockedby = createString("lockedby");

    public final DateTimePath<java.sql.Timestamp> lockgranted = createDateTime("lockgranted", java.sql.Timestamp.class);

    public final com.querydsl.sql.PrimaryKey<Databasechangeloglock> databasechangeloglockPk = createPrimaryKey(id);

    public Databasechangeloglock(String variable) {
        super(Databasechangeloglock.class, forVariable(variable), "LOYALTY", "DATABASECHANGELOGLOCK");
        addMetadata();
    }

    public Databasechangeloglock(String variable, String schema, String table) {
        super(Databasechangeloglock.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public Databasechangeloglock(Path<? extends Databasechangeloglock> path) {
        super(path.getType(), path.getMetadata(), "LOYALTY", "DATABASECHANGELOGLOCK");
        addMetadata();
    }

    public Databasechangeloglock(PathMetadata metadata) {
        super(Databasechangeloglock.class, metadata, "LOYALTY", "DATABASECHANGELOGLOCK");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.DECIMAL).withSize(0).notNull());
        addMetadata(locked, ColumnMetadata.named("LOCKED").withIndex(2).ofType(Types.DECIMAL).withSize(1).notNull());
        addMetadata(lockedby, ColumnMetadata.named("LOCKEDBY").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(lockgranted, ColumnMetadata.named("LOCKGRANTED").withIndex(3).ofType(Types.TIMESTAMP).withSize(11).withDigits(6));
    }

}


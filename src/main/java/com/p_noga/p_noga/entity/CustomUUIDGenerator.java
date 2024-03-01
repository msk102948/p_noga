package com.p_noga.p_noga.entity;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

import static com.p_noga.p_noga.common.Util.makeUuid;

public class CustomUUIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        // id 생성 전략: 생성 테이블 + UUID
        return object.getClass().getSimpleName() + makeUuid(false);
    }
}

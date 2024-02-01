package base.service;

import base.model.BaseEntity;

import java.io.Serializable;

public interface BaseService <ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save (TYPE entity);
    TYPE findById (ID id);
}

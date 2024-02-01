package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;

public interface BaseRepository <ID extends Serializable, TYPE extends BaseEntity<ID>> {
    void save (TYPE entity);
    TYPE findById (ID id);
}

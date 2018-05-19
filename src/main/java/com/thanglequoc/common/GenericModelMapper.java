package com.thanglequoc.common;

import java.util.List;

public interface GenericModelMapper<E, O> {
    public List<O> convertToDtos(List<E> entities);

    public O convertToDto(E entity);
}

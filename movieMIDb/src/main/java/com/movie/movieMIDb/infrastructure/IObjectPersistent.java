package com.movie.movieMIDb.infrastructure;

import java.io.Serializable;

public interface IObjectPersistent<T> extends Serializable {

    T getCodigo();
}

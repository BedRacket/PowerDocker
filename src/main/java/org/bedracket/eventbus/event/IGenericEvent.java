package org.bedracket.eventbus.event;

import java.lang.reflect.Type;

public interface IGenericEvent<T>
{
    Type getGenericType();
}

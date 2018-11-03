package com.pay;
@FunctionalInterface
public interface NameCheckInterface<T,T1,T2> {
	
	T2 findName(T passager,T1 name);
}

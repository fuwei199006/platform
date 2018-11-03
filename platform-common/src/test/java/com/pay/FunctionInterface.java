package com.pay;

import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionInterface {
	
	
	public static void main(String[] args) {
//		Consumer<String> c1 = r -> System.out.printf(r);//有一个输入参数，没有输出
//		c1.accept("1");
//		Consumer<String> c2 = System.out::printf;//有一个输入参数，没有输出
//		c1.accept("2");
		//		Supplier<String> sp = () -> "hello";//只有输出消息，没有输入参数
		//		Consumer<String> cp = r -> System.out.printf(r);//有一个输入参数，没有输出
		//		Function<Integer, String> func = r -> String.valueOf(r);//有一个输入参数 有一个输出参数
		//		BiFunction<Integer, Integer, String> biFunc = (a, b) -> String.valueOf(a + b);//有两个输入参数 有一个输出参数
		//		BiConsumer<Integer, Integer> biCp = (a, b) -> System.out.printf(String.valueOf(a + b));//有两个输入参数 没有输出参数
		 Arrays.asList(1,2,3,4,5).stream().filter(x->{
			System.out.print(x);
			return  x>3;
		}) .forEach(t-> System.out.print(t));
		
		/**
		 *title: 静态的方法demo
		 *PS：函数式接口的实现恰好可以通过调用一个实例方法来实现，那么就可以使用实例方法引用
		 */
//		Consumer<String> c1 = r -> Integer.parseInt(r);
//		c1.accept("1");
//		Consumer<String> c2 =Integer::parseInt;
//		c1.accept("2");
		
		/**
		 *title: 实例方法引用
		 *PS：函数式接口的实现恰好可以通过调用一个实例方法来实现，那么就可以使用实例方法引用
		 */
		//这里是条用 System.out的print方法
//		Consumer<String> ins1 = r -> System.out.print(r);
//		c1.accept("1");
//		Consumer<String> ins2 =System.out::print;
//		c1.accept("2");
		
		/**
		 * title:对象方法引用
		 *PS：抽象方法的第一个参数类型刚好是实例方法的类型，抽象方法剩余的参数恰好可以当做实例方法的参数
		 */
//		Function<BigDecimal,Double> fuc1=t->t.doubleValue();
//		fuc1.apply(new BigDecimal("1.025"));
//		Function<BigDecimal,Double> fuc2=BigDecimal::doubleValue;
//		fuc2.apply(new BigDecimal("1.025"));
		
		
		/**
		 * title:构造方法引用
		 *PS：如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
		 */
//		Consumer<String> n1 = r ->new BigDecimal(r);
//		c1.accept("1");
//		Consumer<String> n2 =BigDecimal::new;
//		c1.accept("2");
	}
	
	
}


 class foo{
	public static void sayHello(){
		System.out.println("hello");
	}
	
}
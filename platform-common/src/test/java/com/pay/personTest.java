package com.pay;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class personTest {
	@Test
	public void simpTest() {
		List<passager> passagerList = new ArrayList<>();
		passagerList.add(new passager("李四", "123456789"));
		passagerList.add(new passager("张三", "123456789"));
		passagerList.add(new passager("王二", "123456789"));
		
		Exception e = new Exception();
		e.printStackTrace();
		excutor(passagerList, (p, str) -> p.getName().equals(str), str -> System.out.println(str));
	}
	
	private void excutor(List<passager> passagerList, BiFunction<passager, String, Boolean> checker, Consumer<String> printer) {
		for (passager p : passagerList) {
			if (checker.apply(p, "李四")) {
				printer.accept(p.getPassagerNo());
			}
		}
		
	}
	
	@Test
	public void TestLambda() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("黎  明", 20, new BigDecimal(80), 1));
		studentList.add(new Student("郭敬明", 22, new BigDecimal(90), 2));
		studentList.add(new Student("明  道", 21, new BigDecimal(65.5), 3));
		studentList.add(new Student("郭富城", 30, new BigDecimal(90.5), 4));
		studentList.add(new Student("刘诗诗", 20, new BigDecimal(75), 1));
		studentList.add(new Student("成  龙", 60, new BigDecimal(88), 5));
		studentList.add(new Student("郑伊健", 60, new BigDecimal(86), 1));
		studentList.add(new Student("刘德华", 40, new BigDecimal(81), 1));
		studentList.add(new Student("古天乐", 50, new BigDecimal(83), 2));
		studentList.add(new Student("赵文卓", 40, new BigDecimal(84), 2));
		studentList.add(new Student("吴奇隆", 30, new BigDecimal(86), 4));
		studentList.add(new Student("言承旭", 50, new BigDecimal(68), 1));
		studentList.add(new Student("郑伊健", 60, new BigDecimal(86), 1));
		studentList.add(new Student("黎  明", 20, new BigDecimal(80), 1));
		studentList.add(new Student("李连杰", 65, new BigDecimal(86), 4));
		studentList.add(new Student("周润发", 69, new BigDecimal(58), 1));
		studentList.add(new Student("徐若萱", 28, new BigDecimal(88), 6));
		studentList.add(new Student("许慧欣", 26, new BigDecimal(86), 8));
		studentList.add(new Student("陈慧琳", 35, new BigDecimal(64), 1));
		studentList.add(new Student("关之琳", 45, new BigDecimal(50), 9));
		studentList.add(new Student("温碧霞", 67, new BigDecimal(53), 2));
		studentList.add(new Student("林青霞", 22, new BigDecimal(56), 3));
		studentList.add(new Student("李嘉欣", 25, new BigDecimal(84), 1));
		studentList.add(new Student("彭佳慧", 26, new BigDecimal(82), 5));
		studentList.add(new Student("陈紫涵", 39, new BigDecimal(88), 1));
		studentList.add(new Student("张韶涵", 41, new BigDecimal(90), 6));
		studentList.add(new Student("梁朝伟", 58, new BigDecimal(74), 1));
		studentList.add(new Student("梁咏琪", 65, new BigDecimal(82), 7));
		studentList.add(new Student("范玮琪", 22, new BigDecimal(83), 1));
		
		//
		//		studentList.stream().forEach(x -> System.out.println(x.getStuName()));
		//
		//		studentList.stream().filter(t -> t.getScore().compareTo(new BigDecimal(80)) > 0).forEach(x -> System.out.println(x.getStuName()));
		//
		//		studentList.stream().distinct().forEach(x -> System.out.println(x.getStuName()));
		//
		//				studentList.stream().sorted(Comparator.comparing(Student::getScore).thenComparing(Student::getStuName)).forEach(x -> System.out.println(x.getStuName()));
		//		studentList.stream().sorted(Comparator.comparing(x -> x.getScore())).forEach(x -> System.out.println(x.getStuName()));
		//		studentList.stream().sorted(Comparator.comparing(Student::getScore)).forEach(x -> System.out.println(x.getStuName()));
		//
		//		studentList.stream().skip(10).limit(5).forEach(x -> System.out.println(x.getStuName()));
		//
		//		studentList.stream().map(x -> x.getScore()).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		//            studentList.stream().map(Student::getScore).forEach(x -> System.out.println(x));
		//		 	studentList.stream().flatMap(x-> Arrays.stream(x.getStuName().split(""))).forEach(x -> System.out.println(x));
		//group
		studentList.stream().max(Comparator.comparing(x -> x.getAge())).ifPresent(x-> System.out.println(x.getAge()));
		studentList.stream().min(Comparator.comparing(x -> x.getAge())).ifPresent(x-> System.out.println(x.getAge()));
		System.out.println(studentList.stream().count());
		studentList.stream().mapToDouble(x -> x.getScore().doubleValue()).average().ifPresent(x-> System.out.println(x));
		
		//	flatMap
		//				studentList.stream().flatMap(x -> Arrays.asList(x.getStuName().toCharArray()).stream()).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		//
		//		studentList.stream().max(Comparator.comparing(x -> x.getAge()));
		//		studentList.stream().min(Comparator.comparing(x -> x.getAge()));
		//		studentList.stream().count();
		//		studentList.stream().mapToDouble(x -> x.getScore().doubleValue()).average();
		//
		//
		
		//    	System.out.println(studentList.stream().anyMatch(r -> r.getStuName().contains("伟")));
		// 		System.out.println(studentList.stream().allMatch(r -> r.getStuName().contains("伟")));
		//		System.out.println(studentList.stream().noneMatch(r -> r.getStuName().contains("伟")));
		// 		System.out.println(studentList.stream().findFirst().get().getStuName());
		//    	System.out.println(studentList.stream().findAny().get().getStuName());
		//		for (int i=0;i<1000;i++){
		//			System.out.println(studentList.stream().parallel().findAny().get().getStuName());
		//		}
		//
		//		System.out.println(studentList.stream().map(x -> x.getScore()).reduce(BigDecimal.ZERO, BigDecimal::add));
		//
		//
		//		studentList.stream().skip(10).limit(5).collect(Collectors.toList());
		//		studentList.stream().skip(10).limit(5).toArray();
		
		//		System.out.println(studentList.stream().collect(Collectors.groupingBy(x->x.getAge(),Collectors.counting())));
		//		Stream.of(1, 5, 10, 8).reduce(100,(x, y) -> {
		//			System.out.println("x : " + x);
		//			System.out.println("y : " + y);
		//			System.out.println("x+y : " +x);
		//			System.out.println("--------");
		//			return x + y;
		//		});
		
		//		ArrayList<IntegerUtils> accResult_ = Stream.of(1, 5, 10, 8).parallel().reduce(new ArrayList<IntegerUtils>(), new BiFunction<ArrayList<IntegerUtils>, IntegerUtils, ArrayList<IntegerUtils>>() {
		//			@Override
		//			public ArrayList<IntegerUtils> apply(ArrayList<IntegerUtils> x, IntegerUtils y) {
		//				x.add(y);
		//				System.out.println("BiFunction");
		//				return x;
		//			}
		//		}, new BinaryOperator<ArrayList<IntegerUtils>>() {
		//			@Override
		//			public ArrayList<IntegerUtils> apply(ArrayList<IntegerUtils> x, ArrayList<IntegerUtils> y) {
		//				x.addAll(y);
		//				System.out.println(Thread.currentThread().getName());
		//				System.out.println("BinaryOperator");
		//				System.out.println("--------");
		//				return x;
		//			}
		//		});
		//		System.out.println("accResult_: " + accResult_);
		//
		//		Optional<Student> std = studentList.stream().filter(x -> x.getStuName().equals("范玮琪")).findFirst();
		//
		//		if (std.get() != null) {
		//			System.out.println(std.get().getAge());
		//		}
		//		std.ifPresent(x -> {
		//			System.out.println(x.getAge());
		//		});
		//		//
		//		//
		//		std.orElse(new Student("范玮琪", 22, new BigDecimal(83), 1));
		//		Student std=new Student("范玮琪",
		//				22, new BigDecimal(83),
		//				1);
		//
		//		if(std==null){
		//			std=  new Student("范玮琪",
		//					22, new BigDecimal(83),
		//					1);
		//		}
		
		//		std.map(x -> x.getStuName()).map(x -> x.toUpperCase()).orElse("");
		//		Student std = new Student("范玮琪", 22, new BigDecimal(83), 1);
		//		String result = "";
		//		if (std != null) {
		//			if (std.getStuName() != null) {
		//				result = std.getStuName().toUpperCase();
		//			} else {
		//				result = "";
		//			}
		//		} else {
		//			result = "";
		//		}
		
		//		Function<BigDecimal, Double> func1 = t -> t.doubleValue();
		//		func1.apply(new BigDecimal("1.025"));
		//		Function<BigDecimal, Double> func2 = BigDecimal::doubleValue;
		//		func2.apply(new BigDecimal("1.025"));
		
		
	}
	
}

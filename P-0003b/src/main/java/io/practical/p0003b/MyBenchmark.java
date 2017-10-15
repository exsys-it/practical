/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package io.practical.p0003b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MyBenchmark {

	private static final int END = 450_000;
	private static final int MIDDLE = 250_000;
	private static final int BEGIN = 0;
	private static int COUNT_ADD = 500_000;
	private static int COUNT_DEL = 10_000;

	private ArrayList<Integer> arrayList;
	private LinkedList<Integer> linkedList;
	private Vector<Integer> vector;
	private HashSet<Integer> hashset;

	@Setup(Level.Trial)
	public void setup() {
		arrayList = new ArrayList<Integer>();
		linkedList = new LinkedList<>();
		vector = new Vector<Integer>();
		hashset = new HashSet<Integer>();
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testMethod() {
		for (int i = 0; i < 100; i++) {
			Math.log(i);
		}
	}

	// Array List

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void testArrayList01Add() {
		for (int i = 0; i < COUNT_ADD; i++) {
			arrayList.add(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testArrayList02Iterator() {
		Iterator<Integer> it = arrayList.iterator();
		while (it.hasNext()) {
			it.next();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testArrayList030RemoveBegin() {
		for (int i = 10_000; i < COUNT_DEL; i++) {
			arrayList.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testArrayList031RemoveMiddle() {
		for (int i = 250_000; i < COUNT_DEL; i++) {
			arrayList.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testArrayList032RemoveEnd() {
		for (int i = 450_000; i < COUNT_DEL; i++) {
			arrayList.remove(i);
		}
	}
	
	// Linked List

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void testLinkedList01Add() {
		for (int i = 0; i < COUNT_ADD; i++) {
			linkedList.add(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testLinkedList02Iterator() {
		Iterator<Integer> it = linkedList.iterator();
		while (it.hasNext()) {
			it.next();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testLinkedList030RemoveBegin() {
		for (int i = 10_000; i < COUNT_DEL; i++) {
			linkedList.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testLinkedList031RemoveMiddle() {
		for (int i = 250_000; i < COUNT_DEL; i++) {
			linkedList.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testLinkedist032RemoveEnd() {
		for (int i = 450_000; i < COUNT_DEL; i++) {
			linkedList.remove(i);
		}
	}
	
	// Vector

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void testVector01Add() {
		for (int i = 0; i < COUNT_ADD; i++) {
			vector.add(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testVector02Iterator() {
		Iterator<Integer> it = vector.iterator();
		while (it.hasNext()) {
			it.next();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testVector030RemoveBegin() {
		for (int i = 10_000; i < COUNT_DEL; i++) {
			vector.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testVector031RemoveMiddle() {
		for (int i = 250_000; i < COUNT_DEL; i++) {
			vector.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testVector032RemoveEnd() {
		for (int i = 450_000; i < COUNT_DEL; i++) {
			vector.remove(i);
		}
	}
	
	// hashset

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void testHashset01Add() {
		for (int i = 0; i < COUNT_ADD; i++) {
			hashset.add(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testHashset02Iterator() {
		Iterator<Integer> it = hashset.iterator();
		while (it.hasNext()) {
			it.next();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testHashset030RemoveBegin() {
		for (int i = BEGIN; i < COUNT_DEL; i++) {
			hashset.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testHashset031RemoveMiddle() {
		for (int i = MIDDLE; i < COUNT_DEL; i++) {
			hashset.remove(i);
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public void testHashset032RemoveEnd() {
		for (int i = END; i < COUNT_DEL; i++) {
			hashset.remove(i);
		}
	}

}

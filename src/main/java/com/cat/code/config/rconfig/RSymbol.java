// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RSymbol.java

package com.cat.code.config.rconfig;

import java.io.File;

public class RSymbol
{

	public static String FILE_SEPARATOR;
	public static final char UNDERLINE = 95;
	public static final char POINT = 46;
	public static final char LINE = 45;
	public static final char COMMA = 44;
	public static final char BRACE_LEFT = 123;
	public static final char BRACE_RIGHT = 125;
	public static final char BRACKET_MIDDLE_LEFT = 91;
	public static final char BRACKET_MIDDLE_RIGHT = 93;
	public static final char BRACKET_SMALL_LEFT = 40;
	public static final char BRACKET_SMALL_RIGHT = 41;

	public RSymbol()
	{
	}

	public static String toString(char value)
	{
		return String.valueOf(value);
	}

	public static String underline()
	{
		return String.valueOf('_');
	}

	static 
	{
		FILE_SEPARATOR = (new StringBuilder()).append(File.separatorChar).toString();
	}
}
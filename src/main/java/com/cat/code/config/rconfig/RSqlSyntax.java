// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RSqlSyntax.java

package com.cat.code.config.rconfig;


public class RSqlSyntax
{

	public static final String SPLITTER = " ,.!@#$%^&*`~'\":;()[]<>{}-=\\+|\n";
	public static final String KEY_STRING = " ADD ALTER AND AS BEGIN BETWEEN BODY BY CLOSE CLUSTER COMMENT COMMIT COST CREATE CURSOR DATABASE DECLARE DEFAULT DEFINE DELETE DROP EACH ELSE ELSIF END ERROR EXCEPTION EXCLUSIVE EXISTS EXIT FALSE FETCH FOR FROM FUNCTION IF IN INDEX INITIAL INSERT INTO IS LOCK LOOP KEY MODE MODIFY NOT NOWAIT NULL OF ON OPEN OR OTHERS OUT PACKAGE PARTITION REVERSE ROW PRAGMA PRIMARY PROCEDURE PROFILE PROMPT RAISE RENAME REPLACE RESOURCE RETURN ROLE ROLLBACK SAVEPOINT SEGMENT SELECT SEQUENCE SESSION SET SHARE SHOW SIZE SQLCODE SQLERRM TABLE THEN TO TRUE UNDEFINE UPDATE VALUES WHEN WHERE WHILE WITH ";
	public static final String TYPE_STRING = " BINARY_INTEGER BOOLEAN CHAR DATE LONG NUMBER ROWTYPE TYPE VARCHAR2 ";
	public static final String FUNCTION_STRING = " ABS ACOS ADD_MONTHS ASCII ASIN ATAN AVG BFILENAME CEIL CHARTOROWID CHR CONCAT CONVERT COS COSH COUNT DEREF DUMP EMPTY_BLOB EMPTY_CLOB EXP FLOOR FOUND GREATEST HEXTORAW INITCAP INSTR INSTRB LAST_DAY LEAST LENGTH LENGTHB LN LOG LOWER LPAD LTRIM MAKE_REF MAX MIN MOD MONTHS_BETWEEN NEW_TIME NEXT_DAY NLS_CHARSET_DECL_LEN NLS_CHARSET_ID NLS_CHARSET_NAME NLS_INITCAP NLS_LOWER NLS_UPPER NLSSORT NOTFOUND NVL POWER RAWTOHEX REFTOHEX REPLACE ROUND ROWIDTOCHAR RPAD RTRIM SIGN SIN SINH SOUNDEX SQRT STDDEV SUBSTR SUBSTRB SUM SYSDATE TAN TANH TO_CHAR TO_DATE TO_MULTI_BYTE TO_NUMBER TO_SINGLE_BYTE TRANSLATE TRANSLATE TRUNC USING UID UPPER USER USERENV VARIANCE VSIZE ";

	public RSqlSyntax()
	{
	}

	public static String format(String sValue)
	{
		StringBuffer oValue = new StringBuffer();
		String sSub = "";
		char chBuffer[] = sValue.toCharArray();
		char chPre = '\0';
		int nLength = chBuffer.length;
		boolean bInString = false;
		boolean bInComment = false;
		boolean bInCommentLine = false;
		for (int i = 0; i < nLength; i++)
		{
			char ch = chBuffer[i];
			if (" ,.!@#$%^&*`~'\":;()[]<>{}-=\\+|\n".indexOf(ch) >= 0)
			{
				if (bInComment && chPre == '*' && ch == '/')
				{
					oValue.append("/</FONT>");
					bInComment = false;
				} else
				{
					if (!bInComment && !bInString)
					{
						if (sSub.length() > 0)
							replaceFormat(oValue, sSub);
					} else
					{
						oValue.append(sSub);
					}
					if (ch == '\n')
					{
						if (bInComment && bInCommentLine)
						{
							oValue.append("</FONT>");
							bInComment = false;
							bInCommentLine = false;
						}
						oValue.append("<br>\n");
					} else
					if (ch == ' ')
						oValue.append("&nbsp;");
					else
					if (ch == '&')
						oValue.append("&amp;");
					else
					if (ch == '<')
						oValue.append("&lt;");
					else
					if (ch == '>')
						oValue.append("&gt;");
					else
					if (ch == '"')
						oValue.append("&quot;");
					else
					if (ch == '\t')
						oValue.append("&quot;&quot;&quot;");
					else
						oValue.append(ch);
					chPre = ch;
					sSub = "";
				}
			} else
			{
				sSub = (new StringBuilder(String.valueOf(sSub))).append(chBuffer[i]).toString();
			}
		}

		return oValue.toString();
	}

	private static boolean replaceFormat(StringBuffer oString, String sSub)
	{
		if (" ADD ALTER AND AS BEGIN BETWEEN BODY BY CLOSE CLUSTER COMMENT COMMIT COST CREATE CURSOR DATABASE DECLARE DEFAULT DEFINE DELETE DROP EACH ELSE ELSIF END ERROR EXCEPTION EXCLUSIVE EXISTS EXIT FALSE FETCH FOR FROM FUNCTION IF IN INDEX INITIAL INSERT INTO IS LOCK LOOP KEY MODE MODIFY NOT NOWAIT NULL OF ON OPEN OR OTHERS OUT PACKAGE PARTITION REVERSE ROW PRAGMA PRIMARY PROCEDURE PROFILE PROMPT RAISE RENAME REPLACE RESOURCE RETURN ROLE ROLLBACK SAVEPOINT SEGMENT SELECT SEQUENCE SESSION SET SHARE SHOW SIZE SQLCODE SQLERRM TABLE THEN TO TRUE UNDEFINE UPDATE VALUES WHEN WHERE WHILE WITH ".indexOf((new StringBuilder(" ")).append(sSub).append(" ").toString()) >= 0)
		{
			oString.append((new StringBuilder("<FONT color='blue'>")).append(sSub).append("</FONT>").toString());
			return true;
		}
		if (" BINARY_INTEGER BOOLEAN CHAR DATE LONG NUMBER ROWTYPE TYPE VARCHAR2 ".indexOf((new StringBuilder(" ")).append(sSub).append(" ").toString()) >= 0)
		{
			oString.append((new StringBuilder("<FONT color='#FF8000'>")).append(sSub).append("</FONT>").toString());
			return true;
		}
		if (" ABS ACOS ADD_MONTHS ASCII ASIN ATAN AVG BFILENAME CEIL CHARTOROWID CHR CONCAT CONVERT COS COSH COUNT DEREF DUMP EMPTY_BLOB EMPTY_CLOB EXP FLOOR FOUND GREATEST HEXTORAW INITCAP INSTR INSTRB LAST_DAY LEAST LENGTH LENGTHB LN LOG LOWER LPAD LTRIM MAKE_REF MAX MIN MOD MONTHS_BETWEEN NEW_TIME NEXT_DAY NLS_CHARSET_DECL_LEN NLS_CHARSET_ID NLS_CHARSET_NAME NLS_INITCAP NLS_LOWER NLS_UPPER NLSSORT NOTFOUND NVL POWER RAWTOHEX REFTOHEX REPLACE ROUND ROWIDTOCHAR RPAD RTRIM SIGN SIN SINH SOUNDEX SQRT STDDEV SUBSTR SUBSTRB SUM SYSDATE TAN TANH TO_CHAR TO_DATE TO_MULTI_BYTE TO_NUMBER TO_SINGLE_BYTE TRANSLATE TRANSLATE TRUNC USING UID UPPER USER USERENV VARIANCE VSIZE ".indexOf((new StringBuilder(" ")).append(sSub).append(" ").toString()) >= 0)
		{
			oString.append((new StringBuilder("<FONT color='green'>")).append(sSub).append("</FONT>").toString());
			return true;
		} else
		{
			oString.append(sSub);
			return true;
		}
	}
}
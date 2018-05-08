// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RJavaSyntax.java

package com.cat.code.config.rconfig;


public class RJavaSyntax
{

	public static final String COMMENT_COLOR = "green";
	public static final String STRING_COLOR = "#800000";
	public static final String KEY_COLOR = "blue";
	public static final String EXCEPTION_COLOR = "red";
	public static final String SPLITTER = " `~!@#$%^&*()-=\\+|[]{};':\",./<>?\t\r\n";
	public static final String KEY_STRING = " abstract break byte boolean catch case class char continue default double do else extends false final float for finally if import implements int interface instanceof long length native new null package private protected public return switch synchronized short static super try true this throw throws threadsafe transient void while ";
	public static final String EXCEPTION_STRING = " AbstractMethodError AccessException Acl AclEntry AclNotFoundException ActionEvent ActionListener Adjustable AdjustmentEvent AdjustmentListener Adler32 AlreadyBoundException Applet AppletContext AppletStub AreaAveragingScaleFilter ArithmeticException Array ArrayIndexOutOfBoundsException ArrayStoreException AudioClip AWTError AWTEvent AWTEventMulticaster AWTException BeanDescriptor BeanInfo Beans BigDecimal BigInteger BindException BitSet Boolean BorderLayout BreakIterator BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter Button ButtonPeer Byte ByteArrayInputStream ByteArrayOutputStream Calendar CallableStatement Canvas CanvasPeer Certificate Character CharacterIterator CharArrayReader CharArrayWriter CharConversionException Checkbox CheckboxGroup CheckboxMenuItem CheckboxMenuItemPeer CheckboxPeer CheckedInputStream CheckedOutputStream Checksum Choice ChoiceFormat ChoicePeer Class ClassCastException ClassCircularityError ClassFormatError ClassLoader ClassNotFoundException Clipboard ClipboardOwner Cloneable CloneNotSupportedException CollationElementIterator CollationKey Collator Color ColorModel Compiler Component ComponentAdapter ComponentEvent ComponentListener ComponentPeer ConnectException ConnectIOException Connection Constructor Container ContainerAdapter ContainerEvent ContainerListener ContainerPeer ContentHandler ContentHandlerFactory CRC32 CropImageFilter Cursor Customizer CardLayout DatabaseMetaData DataFlavor DataFormatException DatagramPacket DatagramSocket DatagramSocketImpl DataInput DataInputStream DataOutput DataOutputStream DataTruncation Date DateFormat DateFormatSymbols DecimalFormat DecimalFormatSymbols Deflater DeflaterOutputStream DGC Dialog DialogPeer Dictionary DigestException DigestInputStream DigestOutputStream Dimension DirectColorModel Double Driver DriverManager DriverPropertyInfo DSAKey DSAKeyPairGenerator DSAParams DSAPrivateKey DSAPublicKey EmptyStackException Enumeration EOFException Error Event EventListener EventObject EventQueue EventSetDescriptor Exception ExceptionInInitializerError ExportException FeatureDescriptor Field FieldPosition File FileDescriptor FileDialog FileDialogPeer FileInputStream FilenameFilter FileNameMap FileNotFoundException FileOutputStream FileReader FileWriter FilteredImageSource FilterInputStream FilterOutputStream FilterReader FilterWriter Float FlowLayout FocusAdapter FocusEvent FocusListener Font FontMetrics FontPeer Format Frame FramePeer Graphics GregorianCalendar GridBagConstraints GridBagLayout GridLayout Group GZIPInputStream GZIPOutputStream Hashtable HttpURLConnection Identity IdentityScope IllegalAccessError IllegalAccessException IllegalArgumentException IllegalComponentStateException IllegalMonitorStateException IllegalStateException IllegalThreadStateException Image ImageConsumer ImageFilter ImageObserver ImageProducer IncompatibleClassChangeError IndexColorModel IndexedPropertyDescriptor IndexOutOfBoundsException InetAddress Inflater InflaterInputStream InputEvent InputStream InputStreamReader Insets InstantiationError InstantiationException Integer InternalError InterruptedException InterruptedIOException IntrospectionException Introspector InvalidClassException InvalidKeyException InvalidObjectException InvalidParameterException InvocationTargetException IOException ItemEvent ItemListener ItemSelectable Key KeyAdapter KeyEvent KeyException KeyListener KeyManagementException KeyPair KeyPairGenerator Label LabelPeer LastOwnerException LayoutManager LayoutManager2 Lease LightweightPeer LineNumberInputStream LineNumberReader LinkageError List ListPeer ListResourceBundle LoaderHandler Locale LocateRegistry LogStream Long MalformedURLException MarshalException Math MediaTracker Member MemoryImageSource Menu MenuBar MenuBarPeer MenuComponent MenuComponentPeer MenuContainer MenuItem MenuItemPeer MenuPeer MenuShortcut MessageDigest MessageFormat Method MethodDescriptor MissingResourceException Modifier MouseAdapter MouseEvent MouseListener MouseMotionAdapter MouseMotionListener MulticastSocket Naming NegativeArraySizeException NoClassDefFoundError NoRouteToHostException NoSuchAlgorithmException NoSuchElementException NoSuchFieldError NoSuchFieldException NoSuchMethodError NoSuchMethodException NoSuchObjectException NoSuchProviderException NotActiveException NotBoundException NotOwnerException NotSerializableException NullPointerException Number NumberFormat NumberFormatException Object ObjectInput ObjectInputStream ObjectInputValidation ObjectOutput ObjectOutputStream ObjectStreamClass ObjectStreamException ObjID Observable Observer Operation OptionalDataException OutOfMemoryError OutputStream OutputStreamWriter Owner PaintEvent Panel PanelPeer ParameterDescriptor ParseException ParsePosition Permission PipedInputStream PipedOutputStream PipedReader PipedWriter PixelGrabber Point Polygon PopupMenu PopupMenuPeer PreparedStatement Principal PrintGraphics PrintJob PrintStream PrintWriter PrivateKey Process Properties PropertyChangeEvent PropertyChangeListener PropertyChangeSupport PropertyDescriptor PropertyEditor PropertyEditorManager PropertyEditorSupport PropertyResourceBundle PropertyVetoException ProtocolException Provider ProviderException PublicKey PushbackInputStream PushbackReader Random RandomAccessFile Reader Rectangle Registry RegistryHandler Remote RemoteCall RemoteException RemoteObject RemoteRef RemoteServer RemoteStub ReplicateScaleFilter ResourceBundle ResultSet ResultSetMetaData RGBImageFilter RMIClassLoader RMIFailureHandler RMISecurityException RMISecurityManager RMISocketFactory RuleBasedCollator Runnable Runtime RuntimeException Scrollbar ScrollbarPeer ScrollPane ScrollPanePeer SecureRandom Security SecurityException SecurityManager SequenceInputStream Serializable ServerCloneException ServerError ServerException ServerNotActiveException ServerRef ServerRuntimeException ServerSocket Shape Short Signature SignatureException Signer SimpleBeanInfo SimpleDateFormat SimpleTimeZone Skeleton SkeletonMismatchException SkeletonNotFoundException Socket SocketException SocketImpl SocketImplFactory SocketSecurityException SQLException SQLWarning Stack StackOverflowError Statement StreamCorruptedException StreamTokenizer String StringBuffer StringBufferInputStream StringCharacterIterator StringIndexOutOfBoundsException StringReader StringSelection StringTokenizer StringWriter StubNotFoundException SyncFailedException System SystemColor TextArea TextAreaPeer TextComponent TextComponentPeer TextEvent TextField TextFieldPeer TextListener Thread ThreadDeath ThreadGroup Throwable Time Timestamp TimeZone Toolkit TooManyListenersException Transferable Types UID UnexpectedException UnicastRemoteObject UnknownError UnknownHostException UnknownServiceException UnmarshalException Unreferenced UnsatisfiedLinkError UnsupportedEncodingException UnsupportedFlavorException URL URLConnection URLEncoder URLStreamHandler URLStreamHandlerFactory UTFDataFormatException Vector VerifyError VetoableChangeListener VetoableChangeSupport VirtualMachineError Visibility VMID Void Window WindowAdapter WindowEvent WindowListener WindowPeer WriteAbortedException Writer ZipEntry ZipException ZipFile ZipInputStream ZipOutputStream ";

	public RJavaSyntax()
	{
	}

	public static String format(String sValue)
	{
		if (sValue == null)
			return "";
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
			if (" `~!@#$%^&*()-=\\+|[]{};':\",./<>?\t\r\n".indexOf(ch) >= 0)
			{
				if (!bInComment)
				{
					if (ch == '/')
					{
						if (chBuffer[i + 1] == '/')
						{
							oValue.append("<FONT color='green'>//");
							bInComment = true;
							bInCommentLine = true;
							i++;
							continue;
						}
						if (chBuffer[i + 1] == '*')
						{
							oValue.append("<FONT color='green'>/*");
							bInComment = true;
							i++;
							continue;
						}
					}
					if (!bInString)
					{
						if (ch == '"')
						{
							oValue.append("\"<FONT color='#800000'>");
							bInString = true;
							continue;
						}
					} else
					if (ch == '"')
					{
						oValue.append((new StringBuilder(String.valueOf(sSub))).append("</FONT>\"").toString());
						bInString = false;
						sSub = "";
						continue;
					}
				} else
				if (chPre == '*' && ch == '/')
				{
					oValue.append("/</FONT>");
					bInComment = false;
					continue;
				}
				if (!bInComment)
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
			} else
			{
				sSub = (new StringBuilder(String.valueOf(sSub))).append(chBuffer[i]).toString();
			}
		}

		return oValue.toString();
	}

	private static boolean replaceFormat(StringBuffer oString, String sSub)
	{
		if (" abstract break byte boolean catch case class char continue default double do else extends false final float for finally if import implements int interface instanceof long length native new null package private protected public return switch synchronized short static super try true this throw throws threadsafe transient void while ".indexOf((new StringBuilder(" ")).append(sSub).append(" ").toString()) >= 0)
		{
			oString.append((new StringBuilder("<FONT color='blue'>")).append(sSub).append("</FONT>").toString());
			return true;
		}
		if (" AbstractMethodError AccessException Acl AclEntry AclNotFoundException ActionEvent ActionListener Adjustable AdjustmentEvent AdjustmentListener Adler32 AlreadyBoundException Applet AppletContext AppletStub AreaAveragingScaleFilter ArithmeticException Array ArrayIndexOutOfBoundsException ArrayStoreException AudioClip AWTError AWTEvent AWTEventMulticaster AWTException BeanDescriptor BeanInfo Beans BigDecimal BigInteger BindException BitSet Boolean BorderLayout BreakIterator BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter Button ButtonPeer Byte ByteArrayInputStream ByteArrayOutputStream Calendar CallableStatement Canvas CanvasPeer Certificate Character CharacterIterator CharArrayReader CharArrayWriter CharConversionException Checkbox CheckboxGroup CheckboxMenuItem CheckboxMenuItemPeer CheckboxPeer CheckedInputStream CheckedOutputStream Checksum Choice ChoiceFormat ChoicePeer Class ClassCastException ClassCircularityError ClassFormatError ClassLoader ClassNotFoundException Clipboard ClipboardOwner Cloneable CloneNotSupportedException CollationElementIterator CollationKey Collator Color ColorModel Compiler Component ComponentAdapter ComponentEvent ComponentListener ComponentPeer ConnectException ConnectIOException Connection Constructor Container ContainerAdapter ContainerEvent ContainerListener ContainerPeer ContentHandler ContentHandlerFactory CRC32 CropImageFilter Cursor Customizer CardLayout DatabaseMetaData DataFlavor DataFormatException DatagramPacket DatagramSocket DatagramSocketImpl DataInput DataInputStream DataOutput DataOutputStream DataTruncation Date DateFormat DateFormatSymbols DecimalFormat DecimalFormatSymbols Deflater DeflaterOutputStream DGC Dialog DialogPeer Dictionary DigestException DigestInputStream DigestOutputStream Dimension DirectColorModel Double Driver DriverManager DriverPropertyInfo DSAKey DSAKeyPairGenerator DSAParams DSAPrivateKey DSAPublicKey EmptyStackException Enumeration EOFException Error Event EventListener EventObject EventQueue EventSetDescriptor Exception ExceptionInInitializerError ExportException FeatureDescriptor Field FieldPosition File FileDescriptor FileDialog FileDialogPeer FileInputStream FilenameFilter FileNameMap FileNotFoundException FileOutputStream FileReader FileWriter FilteredImageSource FilterInputStream FilterOutputStream FilterReader FilterWriter Float FlowLayout FocusAdapter FocusEvent FocusListener Font FontMetrics FontPeer Format Frame FramePeer Graphics GregorianCalendar GridBagConstraints GridBagLayout GridLayout Group GZIPInputStream GZIPOutputStream Hashtable HttpURLConnection Identity IdentityScope IllegalAccessError IllegalAccessException IllegalArgumentException IllegalComponentStateException IllegalMonitorStateException IllegalStateException IllegalThreadStateException Image ImageConsumer ImageFilter ImageObserver ImageProducer IncompatibleClassChangeError IndexColorModel IndexedPropertyDescriptor IndexOutOfBoundsException InetAddress Inflater InflaterInputStream InputEvent InputStream InputStreamReader Insets InstantiationError InstantiationException Integer InternalError InterruptedException InterruptedIOException IntrospectionException Introspector InvalidClassException InvalidKeyException InvalidObjectException InvalidParameterException InvocationTargetException IOException ItemEvent ItemListener ItemSelectable Key KeyAdapter KeyEvent KeyException KeyListener KeyManagementException KeyPair KeyPairGenerator Label LabelPeer LastOwnerException LayoutManager LayoutManager2 Lease LightweightPeer LineNumberInputStream LineNumberReader LinkageError List ListPeer ListResourceBundle LoaderHandler Locale LocateRegistry LogStream Long MalformedURLException MarshalException Math MediaTracker Member MemoryImageSource Menu MenuBar MenuBarPeer MenuComponent MenuComponentPeer MenuContainer MenuItem MenuItemPeer MenuPeer MenuShortcut MessageDigest MessageFormat Method MethodDescriptor MissingResourceException Modifier MouseAdapter MouseEvent MouseListener MouseMotionAdapter MouseMotionListener MulticastSocket Naming NegativeArraySizeException NoClassDefFoundError NoRouteToHostException NoSuchAlgorithmException NoSuchElementException NoSuchFieldError NoSuchFieldException NoSuchMethodError NoSuchMethodException NoSuchObjectException NoSuchProviderException NotActiveException NotBoundException NotOwnerException NotSerializableException NullPointerException Number NumberFormat NumberFormatException Object ObjectInput ObjectInputStream ObjectInputValidation ObjectOutput ObjectOutputStream ObjectStreamClass ObjectStreamException ObjID Observable Observer Operation OptionalDataException OutOfMemoryError OutputStream OutputStreamWriter Owner PaintEvent Panel PanelPeer ParameterDescriptor ParseException ParsePosition Permission PipedInputStream PipedOutputStream PipedReader PipedWriter PixelGrabber Point Polygon PopupMenu PopupMenuPeer PreparedStatement Principal PrintGraphics PrintJob PrintStream PrintWriter PrivateKey Process Properties PropertyChangeEvent PropertyChangeListener PropertyChangeSupport PropertyDescriptor PropertyEditor PropertyEditorManager PropertyEditorSupport PropertyResourceBundle PropertyVetoException ProtocolException Provider ProviderException PublicKey PushbackInputStream PushbackReader Random RandomAccessFile Reader Rectangle Registry RegistryHandler Remote RemoteCall RemoteException RemoteObject RemoteRef RemoteServer RemoteStub ReplicateScaleFilter ResourceBundle ResultSet ResultSetMetaData RGBImageFilter RMIClassLoader RMIFailureHandler RMISecurityException RMISecurityManager RMISocketFactory RuleBasedCollator Runnable Runtime RuntimeException Scrollbar ScrollbarPeer ScrollPane ScrollPanePeer SecureRandom Security SecurityException SecurityManager SequenceInputStream Serializable ServerCloneException ServerError ServerException ServerNotActiveException ServerRef ServerRuntimeException ServerSocket Shape Short Signature SignatureException Signer SimpleBeanInfo SimpleDateFormat SimpleTimeZone Skeleton SkeletonMismatchException SkeletonNotFoundException Socket SocketException SocketImpl SocketImplFactory SocketSecurityException SQLException SQLWarning Stack StackOverflowError Statement StreamCorruptedException StreamTokenizer String StringBuffer StringBufferInputStream StringCharacterIterator StringIndexOutOfBoundsException StringReader StringSelection StringTokenizer StringWriter StubNotFoundException SyncFailedException System SystemColor TextArea TextAreaPeer TextComponent TextComponentPeer TextEvent TextField TextFieldPeer TextListener Thread ThreadDeath ThreadGroup Throwable Time Timestamp TimeZone Toolkit TooManyListenersException Transferable Types UID UnexpectedException UnicastRemoteObject UnknownError UnknownHostException UnknownServiceException UnmarshalException Unreferenced UnsatisfiedLinkError UnsupportedEncodingException UnsupportedFlavorException URL URLConnection URLEncoder URLStreamHandler URLStreamHandlerFactory UTFDataFormatException Vector VerifyError VetoableChangeListener VetoableChangeSupport VirtualMachineError Visibility VMID Void Window WindowAdapter WindowEvent WindowListener WindowPeer WriteAbortedException Writer ZipEntry ZipException ZipFile ZipInputStream ZipOutputStream ".indexOf((new StringBuilder(" ")).append(sSub).append(" ").toString()) >= 0)
		{
			oString.append((new StringBuilder("<FONT color='red'>")).append(sSub).append("</FONT>").toString());
			return true;
		} else
		{
			oString.append(sSub);
			return true;
		}
	}
}
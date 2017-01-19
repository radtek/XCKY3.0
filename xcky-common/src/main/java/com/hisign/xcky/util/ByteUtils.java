package com.hisign.xcky.util;

import com.hisign.xcky.constant.Constants;


public final class ByteUtils {

	public static int toInt( byte[] bytes ) {
		int result = 0;
		for (int i=0; i<4; i++) {
			result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	public static short toShort( byte[] bytes ) {
			return (short) ( ( ( - (short) Byte.MIN_VALUE + (short) bytes[0] ) << 8  ) - (short) Byte.MIN_VALUE + (short) bytes[1] );
	}

	public static byte[] toBytes(int value) {
		byte[] result = new byte[4];
		for (int i=3; i>=0; i--) {
			result[i] = (byte) ( ( 0xFFl & value ) + Byte.MIN_VALUE );
			value >>>= 8;
		}
		return result;
	}

	public static byte[] toBytes(short value) {
		byte[] result = new byte[2];
		for (int i=1; i>=0; i--) {
			result[i] = (byte) ( ( 0xFFl & value )  + Byte.MIN_VALUE );
			value >>>= 8;
		}
		return result;
	}

	/**
	 * Convert Byte Array to Hex Value
	 *
	 * @param buf Byte Array to convert to Hex Value
	 * @param offset Starting Offset for Conversion
	 * @param length Length to convery
	 * @param value Hex Value
	 */
	public static void toHexValue(byte[] buf, int offset, int length, int value) {
		do {
			buf[offset + --length] = Constants.HEX_DIGITS[value & 0x0f];
			value >>>= 4;
		} while (value != 0 && length > 0);

		while (--length >= 0) {
			buf[offset + length] = Constants.HEX_DIGITS[0];
		}
	}

}

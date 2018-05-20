package block.util;

public class CommonUtil {
	// hex -> byte
	public byte getByteFromHex(String param) {
		return (byte) Integer.parseInt(param, 16);
	}

	// hex -> byte[]
	public byte[] getBytesFromHex(byte[] temp, String param) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = getByteFromHex(param.substring(2 * i, 2 * (i + 1)));
		}
		return temp;
	}

	// reverse hex -> byte[]
	public byte[] getBytesFromReverseHex(byte[] temp, String param) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = getByteFromHex(param.substring(2 * (temp.length - i - 1), 2 * (temp.length - i)));
		}
		return temp;
	}
	
	// Integer -> byte
	public byte getByteFromInteger(int param, int pos) {
		return (byte) ((param >>> 8 * pos) & 0xff);
	}

	public boolean byteCompare(byte[] target, byte[] encodedHash) {
		for (int i = 0; i < 32; i++) {
			int unsignedIntTarget = getUnsignedIntegerFromByte(target[i]);			
			int unsignedIntHash = getUnsignedIntegerFromByte(encodedHash[i]);	
			
			if(unsignedIntTarget > unsignedIntHash) 
				return true;
			else if(unsignedIntTarget < unsignedIntHash) 
				return false;
		}
		return true;
	}
	
	public int getUnsignedIntegerFromByte(byte param) {
		return (int) (param & 0xff);
	}
}

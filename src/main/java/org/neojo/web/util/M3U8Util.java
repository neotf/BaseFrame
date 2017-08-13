package org.neojo.web.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.neojo.web.entity.M3U8;

public class M3U8Util {
	public static List<M3U8> toM3U8(String m3u8) {
		String[] M3u8Array = m3u8.split("\n");
		List<M3U8> MEL = new ArrayList<>();
		for (int i = 0; i < M3u8Array.length; i++) {
			if (!M3u8Array[i].isEmpty() && M3u8Array[i].startsWith("#EXT-X-STREAM-INF")) {
				if (!M3u8Array[i + 1].isEmpty() && !M3u8Array[i + 1].startsWith("#EXT-X-STREAM-INF")) {
					M3U8 me = new M3U8();
					Pattern p = Pattern.compile("([A-Za-z-_]+)(=|=\")([A-Za-z0-9,.]+)[,(\",)]");
					Matcher m = p.matcher(M3u8Array[i].substring(18) + ",");
					while (m.find()) {
						if (m.group(1).equals("PROGRAM-ID")) {
							me.setPROGRAM_ID(Integer.parseInt(m.group(3)));
						} else if (m.group(1).equals("BANDWIDTH")) {
							me.setBANDWIDTH(Integer.parseInt(m.group(3)));
						} else if (m.group(1).equals("RESOLUTION")) {
							me.setRESOLUTION(m.group(3));
						} else if (m.group(1).equals("CODECS")) {
							me.setCODECS(m.group(3));
						}
					}
					me.setFILENAME(M3u8Array[i + 1]);
					MEL.add(me);
				}
			} else if (!M3u8Array[i].isEmpty() && M3u8Array[i].startsWith("#EXTINF:")) {
				if (!M3u8Array[i + 1].isEmpty() && !M3u8Array[i + 1].startsWith("#EXTINF:")) {
					M3U8 me = new M3U8();
					me.setEXTINF(Float.parseFloat(M3u8Array[i].substring(8,M3u8Array[i].length()-1)));
					me.setFILENAME(M3u8Array[i + 1]);
					MEL.add(me);
				}
			}
		}
		return MEL;
	}
}

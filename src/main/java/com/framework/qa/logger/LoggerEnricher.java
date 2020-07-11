package com.framework.qa.logger;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.testng.Reporter;

public class LoggerEnricher {

    protected static String tzUTC = "UTC";

    public synchronized static void enrichReporterLog(Object enrichType, Object message) {
        Reporter.setEscapeHtml(false);

        TimeZone timezone = null;
        Color color = null;
        if (enrichType instanceof TimeZone) {
            timezone = (TimeZone) enrichType;

            Reporter.log(getTimeStamp(timezone) + " " + message + "");
        } else if (enrichType instanceof Color) {
            timezone = TimeZone.getTimeZone(tzUTC);
            color = (Color) enrichType;

            Reporter.log(getTimeStamp(timezone) + " " + "<font color='" + color.toString().toLowerCase() + "'>" + message + "</font>");
        } else if (enrichType instanceof EnricherFactory) {
            timezone = TimeZone.getTimeZone(tzUTC);

            EnricherFactory enrichValue = EnricherFactory.equalsTo(enrichType);

            if (enrichValue != null) {
                switch (enrichValue) {
                    case RED:
                    case GREEN:
                    case YELLOW:
                    case PURPLE: {
                        Reporter.log(getTimeStamp(timezone) + " " + "<font color='" + enrichType.toString().toLowerCase() + "'>" + message + "</font>");
                        break;
                    }
                    case BOLD_RED:
                    case BOLD_GREEN:
                    case BOLD_YELLOW:
                    case BOLD_PURPLE: {
                        Reporter.log(getTimeStamp(timezone) + " " + "<b><font color='" + enrichType.toString().toLowerCase().split("_")[1] + "'>" + message + "</font></b>");
                        break;
                    }
                    case ITALIC_RED:
                    case ITALIC_GREEN:
                    case ITALIC_YELLOW:
                    case ITALIC_PURPLE: {
                        Reporter.log(getTimeStamp(timezone) + " " + "<i><font color='" + enrichType.toString().toLowerCase().split("_")[1] + "'>" + message + "</font></i>");
                        break;
                    }
                    case BOLD: {
                        Reporter.log(getTimeStamp(timezone) + " " + "<b>" + message + "</b>");
                        break;
                    }
                    case ITALIC: {
                        Reporter.log(getTimeStamp(timezone) + " " + "<i>" + message + "</i>");
                        break;
                    }
                    default: {
                        Reporter.log(getTimeStamp(timezone) + " " + message + "");
                        break;
                    }
                }
            }

        } else {
            if (enrichType.toString().startsWith("#")) {
                timezone = TimeZone.getTimeZone(tzUTC);

                if (enrichType.toString().toLowerCase().contains("bold") && enrichType.toString().toLowerCase().contains("italic")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<b><i><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("bold", "").replaceAll("italic", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></i></b>");
                } else if (enrichType.toString().toLowerCase().contains("bold")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<b><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("bold", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></b>");
                } else if (enrichType.toString().toLowerCase().contains("italic")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<i><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("italic", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></i>");
                } else {
                    Reporter.log(getTimeStamp(timezone) + " " + "<font color='" + enrichType.toString().toLowerCase() + "'>" + message + "</font>");
                }
            } else if (colorFactoryEquals(enrichType.toString().toLowerCase().replaceAll("bold", "").replaceAll("italic", "").replaceAll("\\s", "").replaceAll("_", ""))) {
                timezone = TimeZone.getTimeZone(tzUTC);

                if (enrichType.toString().toLowerCase().contains("bold") && enrichType.toString().toLowerCase().contains("italic")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<b><i><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("bold", "").replaceAll("italic", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></i></b>");
                } else if (enrichType.toString().toLowerCase().contains("bold")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<b><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("bold", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></b>");
                } else if (enrichType.toString().toLowerCase().contains("italic")) {
                    Reporter.log(getTimeStamp(timezone) + " " + "<i><font color='" +
                            enrichType.toString().toLowerCase().replaceAll("italic", "").replaceAll("\\s", "").replaceAll("_", "") + "'>" + message + "</font></i>");
                } else {
                    Reporter.log(getTimeStamp(timezone) + " " + "<font color='" + enrichType.toString().toLowerCase() + "'>" + message + "</font>");
                }
            } else if (timezoneFactoryEquals(enrichType.toString().toUpperCase())) {
                timezone = TimeZone.getTimeZone(enrichType.toString().toUpperCase());
                Reporter.log(getTimeStamp(timezone) + " " + message + "");
            } else {
                timezone = TimeZone.getDefault();
                Reporter.log(getTimeStamp(timezone) + " " + message + "");
            }

        }
    }

    public static String getTimeStamp(TimeZone timezone) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
        formatter.setTimeZone(timezone);
        java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        return formatter.format(ts) + " " + timezone.getID();
    }

    public static boolean colorFactoryEquals(String value) {
        for (ColorFactory c : ColorFactory.values()) {
            if (c.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean timezoneFactoryEquals(String value) {
        for (TimeZoneFactory tz : TimeZoneFactory.values()) {
            if (tz.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public enum EnricherFactory {
        RED("red"), GREEN("green"), YELLOW("yellow"), PURPLE("#8241f9"), ORANGE("#ffa500"),
        BOLD_RED("bold_red"), BOLD_GREEN("bold_green"), BOLD_YELLOW("bold_yellow"), BOLD_PURPLE("bold_#8241f9"),
        ITALIC_RED("italic_red"), ITALIC_GREEN("italic_green"), ITALIC_YELLOW("italic_yellow"), ITALIC_PURPLE("italic_#8241f9"),
        BOLD("bold"), ITALIC("italic"), CUSTOM("custom"),
        DEFAULT("default");

        private String enrichType;

        EnricherFactory(String enrichType) {
            this.enrichType = enrichType;
        }

        public static EnricherFactory equalsTo(Object enrichValue) {
            for (EnricherFactory enumValue : values()) {
                if (enrichValue.equals(enumValue)) {
                    return enumValue;
                }
            }
            return null;
        }

        public String getEnrichType() {
            return this.enrichType;
        }
    }

    public enum ColorFactory {
        ALICEBLUE("#F0F8FF"), ANTIQUEWHITE("#FAEBD7"), AQUA("#00FFFF"), AQUAMARINE("#7FFFD4"), AZURE("#F0FFFF"),
        BEIGE("#F5F5DC"), BISQUE("#FFE4C4"), BLACK("#000000"), BLANCHEDALMOND("#FFEBCD"), BLUE("#0000FF"), BLUEVIOLET("#8A2BE2"), BROWN("#A52A2A"), BURLYWOOD("#DEB887"),
        CADETBLUE("#5F9EA0"), CHARTREUSE("#7FFF00"), CHOCOLATE("#D2691E"), CORAL("#FF7F50"), CORNFLOWERBLUE("#6495ED"), CORNSILK("#FFF8DC"), CRIMSON("#DC143C"), CYAN("#00FFFF"),
        DARKBLUE("#00008B"), DARKCYAN("#008B8B"), DARKGOLDENROD("#B8860B"), DARKGRAY("#A9A9A9"), DARKGREEN("#006400"), DARKGREY("#A9A9A9"), DARKKHAKI("#BDB76B"), DARKMAGENTA("#8B008B"),
        DARKOLIVEGREEN("#556B2F"), DARKORANGE("#FF8C00"), DARKORCHID("#9932CC"), DARKRED("#8B0000"), DARKSALMON("#E9967A"), DARKSEAGREEN("#8FBC8F"), DARKSLATEBLUE("#483D8B"),
        DARKSLATEGRAY("#2F4F4F"), DARKTURQUOISE("#00CED1"), DARKVIOLET("#9400D3"), DEEPPINK("#FF1493"), DEEPSKYBLUE("#00BFFF"), DIMGRAY("#696969"), DIMGREY("#696969"), DODGERBLUE("#1E90FF"),
        FIREBRICK("#B22222"), FLORALWHITE("#FFFAF0"), FORESTGREEN("#228B22"), FUCHSIA("#FF00FF"),
        GAINSBORO("#DCDCDC"), GHOSTWHITE("#F8F8FF"), GOLD("#FFD700"), GOLDENROD("#DAA520"), GRAY("#808080"), GREY("#808080"), GREEN("#008000"), GREENYELLOW("#ADFF2F"),
        HONEYDEW("#F0FFF0"), HOTPINK("#FF69B4"),
        INDIANRED("#CD5C5C"), INDIGO("#4B0082"), IVORY("#FFFFF0"),
        KHAKI("#F0E68C"),
        LAVENDER("#E6E6FA"), LAVENDERBLUSH("#FFF0F5"), LAWNGREEN("#7CFC00"), LEMONCHIFFON("#FFFACD"), LIGHTBLUE("#ADD8E6"), LIGHTCORAL("#F08080"), LIGHTCYAN("#E0FFFF"), LIGHTGOLDENRODYELLOW("#FAFAD2"),
        LIGHTGRAY("#D3D3D3"), LIGHTGREEN("#90EE90("), LIGHTGREY("#D3D3D3"), LIGHTPINK("#FFB6C1"), LIGHTSALMON("#FFA07A"), LIGHTSEAGREEN("#20B2AA"), LIGHTSKYBLUE("#87CEFA"), LIGHTSLATEGRAY("#778899"),
        LIGHTSLATEGREY("#778899"), LIGHTSTEELBLUE("#B0C4DE"), LIGHTYELLOW("#FFFFE0"), LIME("#00FF00"), LIMEGREEN("#32CD32"), LINEN("#FAF0E6"),
        MAGENTA("#FF00FF"), MAROON("#800000"), MEDIUMAQUAMARINE("#66CDAA"), MEDIUMBLUE("#0000CD"), MEDIUMORCHID("#BA55D3"), MEDIUMPURPLE("#9370DB"), MEDIUMSEAGREEN("#3CB371"), MEDIUMSLATEBLUE("#7B68EE"),
        MEDIUMSPRINGGREEN("#00FA9A"), MEDIUMTURQUOISE("#48D1CC"), MEDIUMVIOLETRED("#C71585"), MIDNIGHTBLUE("#191970"), MINTCREAM("#F5FFFA"), MISTYROSE("#FFE4E1"), MOCCASIN("#FFE4B5"),
        NAVAJOWHITE("#FFDEAD"), NAVY("#000080"),
        OLDLACE("#FDF5E6"), OLIVE("#808000"), OLIVEDRAB("#6B8E23"), ORANGE("#FFA500"), ORANGERED("#FF4500"), ORCHID("#DA70D6"),
        PALEGOLDENROD("#EEE8AA"), PALEGREEN("#98FB98"), PALETURQUOISE("#AFEEEE"), PALEVIOLETRED("#DB7093"), PAPAYAWHIP("#FFEFD5"), PEACHPUFF("#FFDAB9"), PERU("#CD853F"), PINK("#FFC0CB"), PLUM("#DDA0DD"), POWDERBLUE("#B0E0E6"), PURPLE("#800080"),
        RED("#FF0000"), ROSYBROWN("#BC8F8F"), ROYALBLUE("#4169E1"),
        SADDLEBROWN("#8B4513"), SALMON("#FA8072"), SANDYBROWN("#F4A460"), SEAGREEN("#2E8B57"), SEASHELL("#FFF5EE"), SIENNA("#A0522D"), SILVER("#C0C0C0"), SKYBLUE("#87CEEB"), SLATEBLUE("#6A5ACD"),
        SLATEGRAY("#708090"), SLATEGREY("#708090"), SNOW("#FFFAFA"), SPRINGGREEN("#00FF7F"), STEELBLUE("#4682B4"),
        TAN("#D2B48C"), TEAL("#008080"), THISTLE("#D8BFD8"), TOMATO("#FF6347"), TURQUOISE("#40E0D0"),
        VIOLET("#EE82EE"),
        WHEAT("#F5DEB3"), WHITE("#FFFFFF"), WHITESMOKE("#F5F5F5"),
        YELLOW("#FFFF00"), YELLOWGREEN("#9ACD32");

        private String colorType;

        ColorFactory(String colorType) {
            this.colorType = colorType;
        }

        public static ColorFactory equalsTo(Object colorValue) {
            for (ColorFactory enumValue : values()) {
                if (colorValue.equals(enumValue)) {
                    return enumValue;
                }
            }
            return null;
        }

        public String getColorType() {
            return this.colorType;
        }
    }

    public enum TimeZoneFactory {
        ACT("ACT"), AET("AET"), AGT("AGT"), ART("ART"), AST("AST"), BET("BET"), BST("BST"),
        CAT("CAT"), CNT("CNT"), CST("CST"), CTT("CTT"), EAT("EAT"), ECT("ECT"), EST("EST"),
        HST("HST"), IET("IET"), IST("IST"), JST("JST"), MIT("MIT"), MST("MST"), NET("NET"),
        NST("NST"), PLT("PLT"), PNT("PNT"), PRT("PRT"), PST("PST"), SST("SST"), VST("VST");

        private String tzType;

        TimeZoneFactory(String tzType) {
            this.tzType = tzType;
        }

        public static TimeZoneFactory equalsTo(Object tzValue) {
            for (TimeZoneFactory enumValue : values()) {
                if (tzValue.equals(enumValue)) {
                    return enumValue;
                }
            }
            return null;
        }

        public String geTZType() {
            return this.tzType;
        }
    }

}

public interface ParseMibConstants {

    int EOF = 0;

    int IMPORTS = 6;

    int BEGIN = 7;

    int FROM = 8;

    int STATUS = 9;

    int DESCRIPTION = 10;

    int REFERENCE_TOKEN = 11;

    int DEFVAL_TOKEN = 12;

    int AUGMENTS_TOKEN = 13;

    int END = 14;

    int SYNTAX_TOKEN = 15;

    int UNITS_TOKEN = 16;

    int ACCESS_TOKEN = 17;

    int MAX_ACCESS_TOKEN = 18;

    int MIN_ACCESS_TOKEN = 19;

    int NOTIFICATION_TYPE_TOKEN = 20;

    int TRAP_TYPE_TOKEN = 21;

    int LAST_UPDATED_TOKEN = 22;

    int MODULE_IDENTITY_TOKEN = 23;

    int ORGANIZATION_TOKEN = 24;

    int CONTACT_INFO_TOKEN = 25;

    int REVISION_TOKEN = 26;

    int SIZE_TOKEN = 27;

    int SEQUENCE_TOKEN = 28;

    int OF_TOKEN = 29;

    int INDEX_TOKEN = 30;

    int MODULE_COMPLIANCE_TOKEN = 31;

    int MODULE_TOKEN = 32;

    int MANDATORY_GROUPS_TOKEN = 33;

    int GROUP_TOKEN = 34;

    int OBJECT_GROUP_TOKEN = 35;

    int NOTIFICATION_GROUP_TOKEN = 36;

    int NOTIFICATIONS_TOKEN = 37;

    int TEXTUAL_CONVENTION_TOKEN = 38;

    int DISPLAY_HINT_TOKEN = 39;

    int OCTET_TOKEN = 40;

    int STRING_TOKEN = 41;

    int ENTERPRISE_TOKEN = 42;

    int VARIABLES_TOKEN = 43;

    int OBJECT_TYPE = 44;

    int OBJECT_IDENTITY = 45;

    int OBJECT_TOKEN = 46;

    int OBJECTS_TOKEN = 47;

    int IDENTIFIER_TOKEN = 48;

    int LPAREN = 49;

    int RPAREN = 50;

    int LBRACE = 51;

    int RBRACE = 52;

    int LBRACKET = 53;

    int RBRACKET = 54;

    int SEMICOLON = 55;

    int COMMA = 56;

    int QUOTE = 57;

    int INTEGER_LITERAL = 58;

    int DECIMAL_LITERAL = 59;

    int HEX_LITERAL = 60;

    int OCTAL_LITERAL = 61;

    int DESCRIPTOR_LITERAL = 62;

    int REVISION_LITERAL = 63;

    int IDENTIFIER = 64;

    int LETTER = 65;

    int DIGIT = 66;

    int ASSIGN = 67;

    int DEFAULT = 0;

    String[] tokenImage = { "<EOF>", "\" \"", "\"\\t\"", "\"\\n\"", "\"\\r\"", "<token of kind 5>", "\"IMPORTS\"", "\"BEGIN\"", "\"FROM\"", "\"STATUS\"", "\"DESCRIPTION\"", "\"REFERENCE\"", "\"DEFVAL\"", "\"AUGMENTS\"", "\"END\"", "\"SYNTAX\"", "\"UNITS\"", "\"ACCESS\"", "\"MAX-ACCESS\"", "\"MIN-ACCESS\"", "\"NOTIFICATION-TYPE\"", "\"TRAP-TYPE\"", "\"LAST-UPDATED\"", "\"MODULE-IDENTITY\"", "\"ORGANIZATION\"", "\"CONTACT-INFO\"", "\"REVISION\"", "\"SIZE\"", "\"SEQUENCE\"", "\"OF\"", "\"INDEX\"", "\"MODULE-COMPLIANCE\"", "\"MODULE\"", "\"MANDATORY-GROUPS\"", "\"GROUP\"", "\"OBJECT-GROUP\"", "\"NOTIFICATION-GROUP\"", "\"NOTIFICATIONS\"", "\"TEXTUAL-CONVENTION\"", "\"DISPLAY-HINT\"", "\"OCTET\"", "\"STRING\"", "\"ENTERPRISE\"", "\"VARIABLES\"", "\"OBJECT-TYPE\"", "\"OBJECT-IDENTITY\"", "\"OBJECT\"", "\"OBJECTS\"", "\"IDENTIFIER\"", "\"(\"", "\")\"", "\"{\"", "\"}\"", "\"[\"", "\"]\"", "\";\"", "\",\"", "\"\\\"\"", "<INTEGER_LITERAL>", "<DECIMAL_LITERAL>", "<HEX_LITERAL>", "<OCTAL_LITERAL>", "<DESCRIPTOR_LITERAL>", "<REVISION_LITERAL>", "<IDENTIFIER>", "<LETTER>", "<DIGIT>", "\"::=\"", "\".\"", "\"|\"" };
}

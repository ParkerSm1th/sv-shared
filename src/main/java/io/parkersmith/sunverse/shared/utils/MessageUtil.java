package io.parkersmith.sunverse.shared.utils;

/**
 * Created by Chase on 8/4/2017.
 */
public class MessageUtil {

    private final static int CENTER_PX = 154;

    /**
     * This version requires chat colors to already applied to the message before parsing it.
     * @param message The message that will be centered.
     * @return A centered version of the message.
     */
    public static String createCenteredMessage(String message) {

        if (message == null || message.equals(""))
            return "";

//        message = ChatColor.translateAlternateColorCodes('&', message);

        int messagePxSize = 0;
        boolean previousCode = false, isBold = false;

        for (char c : message.toCharArray()) {

            if(c == '§')
                previousCode = true;

            else if(previousCode) {
                previousCode = false;

                isBold = (c == 'l' || c == 'L');
            }

            else {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }

        int halvedMessageSize = messagePxSize / 2, toCompensate = CENTER_PX - halvedMessageSize, spaceLength = DefaultFontInfo.SPACE.getLength() + 1, compensated = 0;
        StringBuilder sb = new StringBuilder();

        while(compensated < toCompensate) {
            sb.append(" ");
            compensated += spaceLength;
        }

        return sb.toString() + message;
    }

}

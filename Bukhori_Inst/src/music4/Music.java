/*
 *       _____ _____ _____                _       _
 *      |_   _/  __ \_   _|              (_)     | |
 *        | | | /  \/ | |  ___  ___   ___ _  __ _| |
 *        | | ||      | | / __|/ _ \ / __| |/ _` | |
 *       _| |_| \__/\ | |_\__ \ (_) | (__| | (_| | |
 *      |_____\_____/ |_(_)___/\___/ \___|_|\__,_|_|
 *                   ___
 *                  |  _|___ ___ ___
 *                  |  _|  _| -_| -_|  LICENSE
 *                  |_| |_| |___|___|
 *
 * IT NEWS  <>  PROGRAMMING  <>  HW & SW  <>  COMMUNITY
 *
 * This source code is a part of online courses at IT social
 * network WWW.ICT.SOCIAL
 *
 * Feel free to use it for whatever you want, modify it and share it but
 * don't forget to keep this link in your code.
 *
 * Visit http://www.ict.social/licenses for more information
 */
package music4;

import java.net.MalformedURLException;
import java.net.URL;
import java.applet.*;

public class Music {

    private URL file;

    public Music(String path) {
        try {
            file = new URL("file:" + path);
        } catch (MalformedURLException ex) {
            System.err.println(ex);
        }
        Applet.newAudioClip(file).play();
        Applet.newAudioClip(file).stop();
    }

}

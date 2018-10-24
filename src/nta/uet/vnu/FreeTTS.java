package nta.uet.vnu;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS {
    public static final String VOICE_ALAN = "alan";
    public static final String VOICE_KEVIN = "kevin";
    public static final String VOICE_KEVIN16 = "kevin16";

    private Voice voice;

    public FreeTTS(String voiceName) {

        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceName);

        if (voice == null) {
            System.err.println(
                    "Cannot find a voice named "
                            + voiceName + ".  Please specify a different voice.");
            System.exit(1);
        }
    }

    public void speak(String msg) {
        voice.speak(msg);

    }

    public void open() {
        voice.allocate();
    }

    public void close() {
        voice.deallocate();
    }

    public static void main(String[] args) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        FreeTTS me = new FreeTTS(FreeTTS.VOICE_KEVIN);
        me.open();
        me.speak("Hi");
        me.close();
    }

}

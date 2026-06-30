TRY TO UNDERSTAND HOW THE PATTERNS & LOGICS ARE WORKING

public interface PlaybackStrategy {    void play(String fileName);
    boolean supports(String fileName);
}


public class MP3Strategy implements PlaybackStrategy {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3: " + fileName);
    }
   
    @Override
    public boolean supports(String fileName) {
        return fileName.endsWith(".mp3");
    }
}

public class WAVStrategy implements PlaybackStrategy {
    @Override
    public void play(String fileName) {
        System.out.println("Playing WAV: " + fileName);
    }
   
    @Override
    public boolean supports(String fileName) {
        return fileName.endsWith(".wav");
    }
}

public class AdvancedAudioEngine {
    public void playAdvancedFormat(String filePath, String codec) {
        System.out.println("Advanced engine playing: " + filePath + " with codec: " + codec);
        // Complex audio processing logic
    }
}


public class AdvancedAudioAdapter implements PlaybackStrategy {
    private AdvancedAudioEngine engine = new AdvancedAudioEngine();
   
    @Override
    public void play(String fileName) {
        String codec = determineCodec(fileName);
        engine.playAdvancedFormat(fileName, codec);
    }
   
    @Override
    public boolean supports(String fileName) {
        return fileName.endsWith(".aac") ||
               fileName.endsWith(".flac") ||
               fileName.endsWith(".ogg");
    }
   
    private String determineCodec(String fileName) {
        if (fileName.endsWith(".aac")) return "AAC";
        if (fileName.endsWith(".flac")) return "FLAC";
        if (fileName.endsWith(".ogg")) return "VORBIS";
        return "AAC";
    }
}



//strategy

public class MediaPlayer {
    private List<PlaybackStrategy> strategies;
    private String currentFile;
   
    public MediaPlayer() {
        // Register all available strategies
        strategies = Arrays.asList(
            new MP3Strategy(),
            new WAVStrategy(),
            new AdvancedAudioAdapter()
        );
    }
   
    public void loadFile(String fileName) {
        this.currentFile = fileName;
        System.out.println("Loaded: " + fileName);
    }
   
    public void onPlayButtonClicked() {
        // Strategy Pattern: Find the right strategy based on extension
        for (PlaybackStrategy strategy : strategies) {
            if (strategy.supports(currentFile)) {
                strategy.play(currentFile);
                return;
            }
        }
        System.out.println("Unsupported format!");
    }
}


public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
       
        player.loadFile("song.mp3");
        player.onPlayButtonClicked();  // MP3Strategy
       
        player.loadFile("audio.aac");
        player.onPlayButtonClicked();  // AdvancedAudioAdapter
    }
}

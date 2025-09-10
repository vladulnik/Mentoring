package problemSolvingClasses;

import interfaces.forFiles.Closeable;
import interfaces.forFiles.Readable;
import interfaces.forFiles.Writable;
import statick.Logger;

public class TextFile implements Closeable, Readable, Writable {

    private final Logger logger;
    private State state;
    private Mode mode;
    private final String filePath;
    private final StringBuilder content;

    private enum State {
        OPEN,
        CLOSED
    }

    public enum Mode {
        APPEND,
        OVERWRITE
    }

    public TextFile(String filePath, Mode mode) {
        if(filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("filePath must not be null");
        }
        this.filePath = filePath;
        this.mode = (mode == null) ? Mode.APPEND : mode;
        this.state = State.OPEN;
        this.content = new StringBuilder();

        this.logger = Logger.getInstance("Info", "textfile.log");
        logger.log("OPEN path = " + this.filePath + ", mode = " + this.mode);
    }

    @Override
    public void close() {
        if(state == State.CLOSED) {
            logger.log("Close called on already CLOSED file, path = " + filePath);
        }
        state = State.CLOSED;
        logger.log("CLOSE file, path = " + filePath);
    }

    @Override
    public String read() {
        ensureOpen("read");
        String result = content.toString();
        logger.log("READ path = " + filePath + ", size = " + result.length());
        return result;
    }

    @Override
    public void write(String data) {
        ensureOpen("write");
        if(data == null) {
            throw new IllegalArgumentException("data must not ne null");
        }
        if(mode == Mode.OVERWRITE) {
            content.setLength(0);
        }
        content.append(data);
        logger.log("WRITE path = " + filePath + ", len = " + data.length() + ", mode = " + mode + ", newSize = " + content.length());
    }

    public void setMode(Mode mode) {
        if(mode == null) return;
        ensureOpen("setMode");
        this.mode = mode;
        logger.log("MODE UPDATED path = " + filePath + " -> " + mode);
    }

    public boolean isOpen() {
        return state == State.OPEN;
    }

    public String getFilePath() {
        return filePath;
    }

    private void ensureOpen(String operation) {
        if(state == State.CLOSED) {
            logger.log("ERROR: " + operation + " on CLOSED file, path = " + filePath);
            throw new IllegalStateException("File is CLOSED: " + filePath);
        }
    }
}

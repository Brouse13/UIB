package es.brouse.panels.mainPanel;

import es.brouse.objects.MusicalNote;
import es.brouse.screens.GameScreen;

import java.util.List;

public class GameController {
    private RenderType currentType = RenderType.IDDLE;

    private final View view;
    private final List<MusicalNote> notes;

    public GameController(View view) {
        this.view = view;
        this.notes = GameScreen.notes;
    }

    public void render(RenderType renderType) {
        if (renderType == RenderType.IDDLE) {
            view.renderIddle();
            return;
        }else if(renderType == RenderType.NOTES) {
            view.renderNotes();
            return;
        }

        if (notes.isEmpty()) {
            view.errorChange("Debes crear una melodía antes.");
            return;
        }

        if (currentType != RenderType.IDDLE) {
            view.errorChange("No puedes cambiar de panel ahora mismo");
            return;
        }


        switch (renderType) {
            case REPRODUCE -> view.renderReproduce();
            case GUESS -> view.renderGuess();
        }

        this.currentType = renderType;
    }
    
    public enum RenderType {
        IDDLE,
        NOTES,
        REPRODUCE,
        GUESS,
        EXIT
    }
    
    public interface View {
        void renderIddle();
        void renderNotes();
        void renderReproduce();
        void renderGuess();
        void errorChange(String message);
    }
}

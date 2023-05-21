package es.brouse.panels.mainPanel;

import es.brouse.objects.MusicalNote;
import es.brouse.screens.GameScreen;

import java.util.List;

public class GameController {
    /*---------- PRIVATE ----------*/
    private RenderType currentType = RenderType.IDDLE;

    private final View view;
    private final List<MusicalNote> notes;

    /**
     * Main class constructor that will create new
     * {@link GameController} instances.
     *
     * @param view view to interact wit
     */
    public GameController(View view) {
        this.view = view;
        this.notes = GameScreen.notes;
    }

    /**
     * Render the correct view instance of the game depending on the
     * {@link RenderType}.
     *
     * @param renderType type of render
     */
    public void render(RenderType renderType) {
        if (renderType == RenderType.IDDLE) {
            view.renderIddle();
            this.currentType = RenderType.IDDLE;
            return;
        }else if(renderType == RenderType.NOTES) {
            view.renderNotes();
            this.currentType = RenderType.NOTES;
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

    /**
     * Type of available renders
     */
    public enum RenderType {
        IDDLE,
        NOTES,
        REPRODUCE,
        GUESS,
        EXIT
    }

    /**
     * Interface that acts as interface with the view to make code
     * independent.
     */
    public interface View {
        /**
         * Render the iddle main view.
         */
        void renderIddle();

        /**
         * Render the create melody notes view.
         */
        void renderNotes();

        /**
         * Render the reproduce notes view.
         */
        void renderReproduce();

        /**
         * Render the guess notes view.
         */
        void renderGuess();

        /**
         * Render an error popup.
         *
         * @param message error message
         */
        void errorChange(String message);
    }
}

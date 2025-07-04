package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.protobuf.annotation.ProtobufMessage;
import it.auties.protobuf.annotation.ProtobufProperty;
import it.auties.protobuf.model.ProtobufType;

import java.util.Objects;
import java.util.Optional;

/**
 * A model class that represents a template for a button
 */
@ProtobufMessage(name = "HydratedTemplateButton")
public final class HighlyStructuredButtonTemplate {

    @ProtobufProperty(index = 1, type = ProtobufType.MESSAGE)
    final HighlyStructuredQuickReplyButton highlyStructuredQuickReplyButton;

    @ProtobufProperty(index = 2, type = ProtobufType.MESSAGE)
    final HighlyStructuredURLButton highlyStructuredUrlButton;

    @ProtobufProperty(index = 3, type = ProtobufType.MESSAGE)
    final HighlyStructuredCallButton highlyStructuredCallButton;

    @ProtobufProperty(index = 4, type = ProtobufType.UINT32)
    final int index;

    HighlyStructuredButtonTemplate(HighlyStructuredQuickReplyButton highlyStructuredQuickReplyButton,
                                   HighlyStructuredURLButton highlyStructuredUrlButton,
                                   HighlyStructuredCallButton highlyStructuredCallButton,
                                   int index) {
        this.highlyStructuredQuickReplyButton = highlyStructuredQuickReplyButton;
        this.highlyStructuredUrlButton = highlyStructuredUrlButton;
        this.highlyStructuredCallButton = highlyStructuredCallButton;
        this.index = index;
    }

    /**
     * Constructs a new template
     *
     * @param highlyStructuredButton the button
     * @return a non-null button template
     */
    public static HighlyStructuredButtonTemplate of(HighlyStructuredButton highlyStructuredButton) {
        return of(-1, highlyStructuredButton);
    }

    /**
     * Constructs a new template
     *
     * @param index                  the index
     * @param highlyStructuredButton the button
     * @return a non-null button template
     */
    public static HighlyStructuredButtonTemplate of(int index, HighlyStructuredButton highlyStructuredButton) {
        var builder = new HighlyStructuredButtonTemplateBuilder()
                .index(index);
        switch (highlyStructuredButton) {
            case HighlyStructuredQuickReplyButton highlyStructuredQuickReplyButton ->
                    builder.highlyStructuredQuickReplyButton(highlyStructuredQuickReplyButton);
            case HighlyStructuredURLButton highlyStructuredURLButton ->
                    builder.highlyStructuredUrlButton(highlyStructuredURLButton);
            case HighlyStructuredCallButton highlyStructuredCallButton ->
                    builder.highlyStructuredCallButton(highlyStructuredCallButton);
            case null -> {
            }
        }
        return builder.build();
    }

    public Optional<HighlyStructuredQuickReplyButton> highlyStructuredQuickReplyButton() {
        return Optional.ofNullable(highlyStructuredQuickReplyButton);
    }

    public Optional<HighlyStructuredURLButton> highlyStructuredUrlButton() {
        return Optional.ofNullable(highlyStructuredUrlButton);
    }

    public Optional<HighlyStructuredCallButton> highlyStructuredCallButton() {
        return Optional.ofNullable(highlyStructuredCallButton);
    }

    public int index() {
        return index;
    }

    /**
     * Returns this button
     *
     * @return a non-null optional
     */
    public Optional<? extends HighlyStructuredButton> button() {
        if (highlyStructuredQuickReplyButton != null) {
            return Optional.of(highlyStructuredQuickReplyButton);
        }

        if (highlyStructuredUrlButton != null) {
            return Optional.of(highlyStructuredUrlButton);
        }

        return Optional.ofNullable(highlyStructuredCallButton);
    }

    /**
     * Returns the type of button that this message wraps
     *
     * @return a non-null button type
     */
    public HighlyStructuredButton.Type buttonType() {
        return button().map(HighlyStructuredButton::buttonType)
                .orElse(HighlyStructuredButton.Type.NONE);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HighlyStructuredButtonTemplate that
                && Objects.equals(highlyStructuredQuickReplyButton, that.highlyStructuredQuickReplyButton)
                && Objects.equals(highlyStructuredUrlButton, that.highlyStructuredUrlButton)
                && Objects.equals(highlyStructuredCallButton, that.highlyStructuredCallButton)
                && index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(highlyStructuredQuickReplyButton, highlyStructuredUrlButton, highlyStructuredCallButton, index);
    }

    @Override
    public String toString() {
        return "HighlyStructuredButtonTemplate[" +
                "highlyStructuredQuickReplyButton=" + highlyStructuredQuickReplyButton + ", " +
                "highlyStructuredUrlButton=" + highlyStructuredUrlButton + ", " +
                "highlyStructuredCallButton=" + highlyStructuredCallButton + ", " +
                "index=" + index + ']';
    }
}
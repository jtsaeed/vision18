package com.evh98.vision.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.evh98.vision.ui.Icon;

import java.util.ArrayList;

public class Graphics {

    public static FreeTypeFontGenerator systemFont;

    public static ParticleEffect particles;

    private static GlyphLayout glyphLayout;

    public static ArrayList<Sprite> screensavers;
    public static Sprite cardTopSprite;
    public static Sprite cardBottomSprite;
    public static Sprite search;

    /**
     * Loads everything required by Vision at launch
     */
    public static void loadAll() {
        loadFonts();
        loadSprites();
        loadParticles();

        glyphLayout = new GlyphLayout();
    }

    /**
     * Internal fonts loading method
     */
    private static void loadFonts() {
        systemFont = new FreeTypeFontGenerator(Gdx.files.internal("fonts/productsans.ttf"));
    }

    /**
     * Internal sprites loading method
     */
    private static void loadSprites() {
        loadScreensavers();

        cardTopSprite = createSprite("ui/card_top.png");
        cardBottomSprite = createSprite("ui/card_bottom.png");
        search = createSprite("ui/search.png");

        Icon.loadAll();
    }

    private static void loadScreensavers() {
        screensavers = new ArrayList<Sprite>();

        FileHandle rootFolder = Gdx.files.internal("screensavers");
        for (FileHandle file : rootFolder.list()) {
            if (file.path().contains(".png")) {
                screensavers.add(createSprite(file));
            }
        }
    }

    /**
     * Internal particles loading method
     */
    private static void loadParticles() {
        particles = new ParticleEffect();
        particles.load(Gdx.files.internal("particles/particles.p"), Gdx.files.internal("particles/"));
        particles.setPosition(Util.WIDTH / 2, Util.HEIGHT / 2);
    }

    /**
     * Creates a BitmapFont from a FreeTypeFont with a specified size
     */
    public static BitmapFont createFont(FreeTypeFontGenerator type, int size, Color color) {
        FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        param.size = size;
        param.color = color;
        param.flip = true;
        param.magFilter = Texture.TextureFilter.Linear;
        param.minFilter = Texture.TextureFilter.Linear;
        BitmapFont font = type.generateFont(param);
        return font;
    }

    /**
     * Creates a sprite with custom properties for Vision
     */
    public static Sprite createSprite(String path) {
        Texture t = new Texture(Gdx.files.internal(path));
        t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite s = new Sprite(t);
        s.flip(false, true);
        return s;
    }

    /**
     * Creates a sprite with custom properties for Vision
     */
    public static Sprite createSprite(FileHandle file) {
        Texture t = new Texture(file);
        t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite s = new Sprite(t);
        s.flip(false, true);
        return s;
    }

    /**
     * Draws a sprite with a specified color tint
     */
    public static void drawTintedSprite(SpriteBatch spriteBatch, Sprite sprite, float x, float y, Color color) {
        Color original = spriteBatch.getColor();
        spriteBatch.setColor(color);
        spriteBatch.draw(sprite, x, y, sprite.getWidth(), sprite.getHeight());
        spriteBatch.setColor(original);
    }

    /**
     * Draws a sprite with a specified size and color tint
     */
    public static void drawTintedSprite(SpriteBatch spriteBatch, Sprite sprite, float x, float y, float width, float height, Color color) {
        Color original = spriteBatch.getColor();
        spriteBatch.setColor(color);
        spriteBatch.draw(sprite, x, y, width, height);
        spriteBatch.setColor(original);
    }

    /**
     * Draws centered text
     */
    public static void drawText(SpriteBatch spriteBatch, BitmapFont font, String text, float x, float y) {
        glyphLayout.setText(font, text);
        float cx = x - (glyphLayout.width / 2);
        float cy = y - (glyphLayout.height / 2);
        font.draw(spriteBatch, glyphLayout, cx, cy);
    }

    /**
     * Draws horizontally left aligned text
     */
    public static void drawLeftAlignedText(SpriteBatch spriteBatch, BitmapFont font, String text, float x, float y) {
        glyphLayout.setText(font, text);
        font.draw(spriteBatch, glyphLayout, x, y);
    }

    /**
     * Draws horizontally right aligned text
     */
    public static void drawRightAlignedText(SpriteBatch spriteBatch, BitmapFont font, String text, float x, float y) {
        glyphLayout.setText(font, text);
        float cx = x - glyphLayout.width;
        font.draw(spriteBatch, glyphLayout, cx, y);
    }
}
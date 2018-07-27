package com.evh98.vision.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.evh98.vision.Vision;
import com.evh98.vision.ui.search.Search;
import com.evh98.vision.util.Controller;
import com.evh98.vision.util.Graphics;
import com.evh98.vision.util.Util;

public class VisionScreen implements Screen {

    protected final Vision vision;
    protected final SpriteBatch spriteBatch;
    protected final ShapeRenderer shapeRenderer;
    protected final OrthographicCamera camera;

    private final Search search;

    public VisionScreen(Vision vision) {
        this.vision = vision;
        this.spriteBatch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true, Util.WIDTH, Util.HEIGHT);

        this.search = new Search();
    }

    @Override public void show() {
        Graphics.particles.start();
        onAppear();
    }

    @Override
    public void render(float delta) {
        initGL();
        syncCamera();
        drawParticles(delta);

        if (Controller.search()) {
            search.toggle();
        }

        if (search.isActive()) {
            search.draw(spriteBatch);
            search.update();
        } else {
            draw(delta);
            update();

            handleBack();
            handleTermination();
        }
    }

    public void initGL() {
        Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void syncCamera() {
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void drawParticles(float delta) {
        spriteBatch.begin();
        Graphics.particles.draw(spriteBatch);
        Graphics.particles.update(delta);
        spriteBatch.end();
    }

    private void handleBack() {
        if (Controller.back()) {
            vision.back();
        }
    }

    private void handleTermination() {
        if (Controller.terminate()) {
            vision.terminate();
        }
    }

    public void onAppear() {

    }

    public void draw(float delta) {

    }

    public void update() {

    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}

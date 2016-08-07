package com.bitCode.test.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.bitCode.test.KeyBindings;
import com.bitCode.test.Reference;
import com.bitCode.test.testMod;
import com.bitCode.test.items.Drain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DrainGui extends GuiScreen{

	private static ResourceLocation drainGuiTexture = new ResourceLocation(Reference.MOD_ID + ":drainGui");
    private UpButton upButton;
    private DownButton downButton;
    
	public DrainGui(){
		
	}
	 /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
   
    
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);


        buttonList.add(upButton = new UpButton(1, 210, 28));
        buttonList.add(downButton = new DownButton(2,  210, 66));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {

        upButton.visible = true;
        downButton.visible = true;
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
    	  this.drawDefaultBackground();

          this.drawCenteredString(this.fontRendererObj, Drain.radius +"", this.width / 2, this.height / 2, 16777215);
    //	fontRendererObj.drawString(Drain.radius + "", 10, 10, 333);
    	super.drawScreen(parWidth, parHeight, p_73863_3_);
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. 
     * Parameters are : mouseX, mouseY, lastButtonClicked & 
     * timeSinceMouseClick.
     */
    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, 
          int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
     
    }

    @Override
    protected void actionPerformed(GuiButton parButton) 
    {

		if(parButton == upButton && Drain.radius <= testMod.drainRadius){
			Drain.radius++;
		
		}
		if(parButton == downButton&& Drain.radius >= 0){
			Drain.radius--;
		}
	
   }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat 
     * events
     */
    @Override
    public void onGuiClosed() 
    {
     
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    static class UpButton extends GuiButton
    {


        public UpButton(int parButtonId, int parPosX, int parPosY)
        {
            super(parButtonId, parPosX, parPosY, 25, 24, "");

        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY)
        {
            
            mc.getTextureManager().bindTexture(drainGuiTexture);
                int textureX = 211;
                int textureY = 28;

               

             

                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      25, 24);
            
        }
    }
    @SideOnly(Side.CLIENT)
    static class DownButton extends GuiButton
    {


        public DownButton(int parButtonId, int parPosX, int parPosY)
        {
        	 super(parButtonId, parPosX, parPosY, 25, 24, "");
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY)
        {
           
                
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(drainGuiTexture);
                int textureX = 210;
                int textureY = 66;

             

                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      25, 24);
            
        }
    }
}


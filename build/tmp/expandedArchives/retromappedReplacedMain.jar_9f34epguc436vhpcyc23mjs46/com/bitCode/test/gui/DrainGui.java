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
    public void func_73866_w_() 
    {
   
    
        field_146292_n.clear();
        Keyboard.enableRepeatEvents(true);


        field_146292_n.add(upButton = new UpButton(1, 210, 28));
        field_146292_n.add(downButton = new DownButton(2,  210, 66));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void func_73876_c() 
    {

        upButton.field_146125_m = true;
        downButton.field_146125_m = true;
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void func_73863_a(int parWidth, int parHeight, float p_73863_3_)
    {
    	  this.func_146276_q_();

          this.func_73732_a(this.field_146289_q, Drain.radius +"", this.field_146294_l / 2, this.field_146295_m / 2, 16777215);
    //	fontRendererObj.drawString(Drain.radius + "", 10, 10, 333);
    	super.func_73863_a(parWidth, parHeight, p_73863_3_);
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. 
     * Parameters are : mouseX, mouseY, lastButtonClicked & 
     * timeSinceMouseClick.
     */
    @Override
    protected void func_146273_a(int parMouseX, int parMouseY, 
          int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
     
    }

    @Override
    protected void func_146284_a(GuiButton parButton) 
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
    public void func_146281_b() 
    {
     
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean func_73868_f()
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
        public void func_146112_a(Minecraft mc, int parX, int parY)
        {
            
            mc.func_110434_K().func_110577_a(drainGuiTexture);
                int textureX = 211;
                int textureY = 28;

               

             

                func_73729_b(field_146128_h, field_146129_i, 
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
        public void func_146112_a(Minecraft mc, int parX, int parY)
        {
           
                
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.func_110434_K().func_110577_a(drainGuiTexture);
                int textureX = 210;
                int textureY = 66;

             

                func_73729_b(field_146128_h, field_146129_i, 
                      textureX, textureY, 
                      25, 24);
            
        }
    }
}


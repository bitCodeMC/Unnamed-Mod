package snippet;

public class Snippet {
	 public static FeederUpdateEvent instance = new FeederUpdateEvent();
		 @SubscribeEvent
		  public void onPlayerTick(TickEvent.PlayerTickEvent event)
		  {
			 EntityPlayer player=event.player;
			 BlockPos pos = player.getPosition();
			 
		  }
}


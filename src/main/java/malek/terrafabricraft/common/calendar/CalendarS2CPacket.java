package malek.terrafabricraft.common.calendar;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;

public class CalendarS2CPacket implements Packet<ClientPlayPacketListener> {
    private final String identifier;
    private final NbtCompound counter;

    public CalendarS2CPacket(String identifier, NbtCompound counter) {
        this.identifier = identifier;
        this.counter = counter;
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeNbt(counter);
    }

    @Override
    public void apply(ClientPlayPacketListener listener) {

    }
}

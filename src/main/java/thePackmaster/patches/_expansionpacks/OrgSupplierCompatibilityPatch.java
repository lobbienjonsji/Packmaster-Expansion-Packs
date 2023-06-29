package thePackmaster.patches._expansionpacks;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import thePackmaster.orbs.PackmasterOrb;
import thePackmaster.packs.SpheresPack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static thePackmaster.cards.spherespack.Sphere.SphereOrb.Blaze;
import static thePackmaster.cards.spherespack.Sphere.SphereOrb.Polar;

public class OrgSupplierCompatibilityPatch {
    @SpirePatch2(clz = PackmasterOrb.class, method = "makePackSuppliers")
    public static class AddExpansionSuppliers {
        @SpirePostfixPatch
        public static Map<String, List<Supplier<AbstractOrb>>> patch(Map<String, List<Supplier<AbstractOrb>>> __result) {
            List<Supplier<AbstractOrb>> suppliers;

            suppliers = new ArrayList<>();
            suppliers.add(thePackmaster.orbs.spherespack.Blaze::new);
            suppliers.add(thePackmaster.orbs.spherespack.Polar::new);
            __result.put(SpheresPack.ID, suppliers);
            return __result;
        }
    }
}

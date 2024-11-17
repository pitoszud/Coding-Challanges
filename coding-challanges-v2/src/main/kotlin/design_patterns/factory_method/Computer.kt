package design_patterns.factory_method


fun main() {
    //-------------- Factory Method ------------------
    val laptopFactory = LaptopFactory()
    val laptop1 = laptopFactory.build(Chipset.INTEL)
    laptop1.runTask()

    val mobilePhoneFactory = MobilePhoneFactory()
    mobilePhoneFactory.build(Chipset.QUALCOMM)

    //-------------- Single factory (violates Open-Closed Principle) ------------------

    val computerFactory = ComputerFactoryImpl()
    computerFactory.build(Chipset.INTEL)

    //--------------- Factory method with Registry -----------------

    val registry = ComputerFactoryRegistry()

    registry.registerFactory(Chipset.INTEL) { Laptop(Chipset.INTEL) }
    registry.registerFactory(Chipset.QUALCOMM) { MobilePhone(Chipset.QUALCOMM) }

    val laptop2 = registry.createComputer(Chipset.INTEL)
    laptop2.runTask()

    val mobilePhone2 = registry.createComputer(Chipset.QUALCOMM)
    mobilePhone2.runTask()
}

interface Computer {
    fun showCapabilities(): String
    fun runTask()
}

class Laptop(private val chipset: Chipset) : Computer {
    override fun showCapabilities(): String {
        return "I am a Laptop with $chipset chipset"
    }

    override fun runTask() {
        println("Running task on Laptop using $chipset chipset")
    }
}

class MobilePhone(private val chipset: Chipset) : Computer {
    override fun showCapabilities(): String {
        return "I am a Desktop with $chipset chipset"
    }

    override fun runTask() {
        println("Running task on Desktop using $chipset chipset")
    }
}

abstract class ComputerFactory {
    // Factory method
    abstract fun createComputer(chipset: Chipset): Computer

    // client calls build, but factory decides which object to create
    fun build(chipset: Chipset): Computer {
        val computer = createComputer(chipset)
        println(computer.showCapabilities())
        return computer
    }
}

class LaptopFactory : ComputerFactory() {
    override fun createComputer(chipset: Chipset): Computer {
        return Laptop(chipset)
    }
}

class MobilePhoneFactory : ComputerFactory() {
    override fun createComputer(chipset: Chipset): Computer {
        return MobilePhone(chipset)
    }
}

// ----------------------------

// Convenient, but violates Open-Closed Principle
class ComputerFactoryImpl : ComputerFactory() {
    override fun createComputer(chipset: Chipset): Computer {
        return when (chipset) {
            Chipset.INTEL -> Laptop(chipset)
            Chipset.QUALCOMM -> MobilePhone(chipset)
        }
    }
}


// ----------------------------


class ComputerFactoryRegistry {
    private val factories = mutableMapOf<Chipset, () -> Computer>()

    fun registerFactory(chipset: Chipset, factory: () -> Computer) {
        factories[chipset] = factory
    }

    fun createComputer(chipset: Chipset): Computer {
        val factory = factories[chipset] ?: throw IllegalArgumentException("No factory registered for $chipset")
        return factory()
    }
}


sealed class Chipset {
    data object INTEL : Chipset() {
        override fun toString(): String {
            return "Intel"
        }
    }
    data object QUALCOMM : Chipset() {
        override fun toString(): String {
            return "Qualcomm"
        }
    }
    // Add new chipsets here without modifying existing code
}


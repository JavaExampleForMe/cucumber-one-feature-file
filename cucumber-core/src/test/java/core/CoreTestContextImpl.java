package core;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoreTestContextImpl implements CoreTestContext {

    private CoreService coreService;

    public CoreTestContextImpl(CoreService coreService) {
        this.coreService = coreService;
    }

    @Override
    public boolean isAlive() {
        return coreService.isAlive();
    }

    @Override
    public String printSomething() {
        return coreService.printSomething();
    }

    @Override
    public String getSomething() {
        return coreService.getSomething();
    }

}

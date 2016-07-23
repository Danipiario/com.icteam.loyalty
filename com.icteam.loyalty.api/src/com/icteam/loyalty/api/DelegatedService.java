package com.icteam.loyalty.api;

import com.icteam.loyalty.api.interfaces.IDelegant;
import com.icteam.loyalty.api.interfaces.IDelegated;

public interface DelegatedService {

    <T extends IDelegated, S extends IDelegant> T getDelegated(S delegant, Class<T> delegatedServiceClass);

}

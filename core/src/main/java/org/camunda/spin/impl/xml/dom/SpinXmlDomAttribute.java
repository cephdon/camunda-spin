/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.spin.impl.xml.dom;

import org.camunda.spin.Spin;
import org.w3c.dom.Attr;

/**
 * @author Sebastian Menski
 */
public class SpinXmlDomAttribute extends Spin<SpinXmlDomAttribute> {

  private final Attr attributeNode;

  public SpinXmlDomAttribute(Attr attributeNode) {
    this.attributeNode = attributeNode;
  }

  public String getDataFormatName() {
    return DomDataFormat.INSTANCE.getName();
  }

  public String stringValue() {
    return attributeNode.getValue();
  }

  public String name() {
    return attributeNode.getLocalName();
  }

  public String namespace() {
    String namespaceURI = attributeNode.getNamespaceURI();
    if (namespaceURI != null) {
      return namespaceURI;
    }
    else {
      return attributeNode.lookupNamespaceURI(attributeNode.getPrefix());
    }
  }

  public boolean hasNamespace(String namespace) {
    if (namespace == null) {
      return attributeNode.getNamespaceURI() == null;
    }
    else {
      return namespace.equals(namespace());
    }
  }
}

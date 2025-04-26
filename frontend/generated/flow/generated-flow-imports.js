import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import 'Frontend/generated/jar-resources/vaadin-grid-flow-selection-column.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column.js';
import '@vaadin/text-field/theme/lumo/vaadin-text-field.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/dialog/theme/lumo/vaadin-dialog.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/grid/theme/lumo/vaadin-grid.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-sorter.js';
import '@vaadin/checkbox/theme/lumo/vaadin-checkbox.js';
import 'Frontend/generated/jar-resources/gridConnector.ts';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column-group.js';
import 'Frontend/generated/jar-resources/lit-renderer.ts';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === 'dc54f3f1a25048f4e58b818b2803a93e9be860a6028b1918ba52fa5d3228b2ab') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  if (key === 'c5b007bd5a0aca3d184fee111d35ee9ace4231a9deabdca94b7da2bf9c593671') {
    pending.push(import('./chunks/chunk-49b22055ef5f5552171cea2d4df1d8619c822dceff4b65a9052662cd858df86f.js'));
  }
  if (key === 'aa48c45be28a503244cbbaeedf83c70543b6874196373acfd0ea38ba0e98f780') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  if (key === 'afa626c8c5bb539b1ff3e765f1360cb4cb6db4d8ebdebdb9bb88c635ec40012b') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  if (key === '1bb0f28a924a10d57ef26a7a6d4153259f4fb86d9057a058db9f4b24513c686d') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  if (key === '9e5d163688875405922ec2c1ed0042f52323b09e9764738317f1f88ffce3e514') {
    pending.push(import('./chunks/chunk-4e584d2e230ec70786b51c0d90caa379dce7c3e4b98257baa897d45273a581c1.js'));
  }
  if (key === '343d1edf425301e24ff342c2f6b905db6d133f9f7fd49ac86ac8e077808af19b') {
    pending.push(import('./chunks/chunk-e666b5e1b4a9638eb6680d7e0ef5a6c5ac3f59445f944d66d189c9953f7f27e0.js'));
  }
  if (key === '868c1287ad14e5360f25a205ae8415fabe4ed68d27d4d2fe43061236c40ff585') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  if (key === '03f4163eae2abee8e143719af8ed4e318bfbe91f4825d6e5c22a568630a53ac0') {
    pending.push(import('./chunks/chunk-e666b5e1b4a9638eb6680d7e0ef5a6c5ac3f59445f944d66d189c9953f7f27e0.js'));
  }
  if (key === '30976f3ec69e423a2c86176d69b38ce0ba87d9e0800a33695b9dbe50af38be55') {
    pending.push(import('./chunks/chunk-46437ea5612ab8481d42e6c8855749bedf4084d28c2c2328866078529eabed68.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}